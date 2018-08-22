package aglf.migration;

import aglf.data.dao.*;
import aglf.data.model.*;
import aglf.service.RestClient;
import aglf.service.dto.restmapping.matchlineups.Lineup;
import aglf.service.dto.restmapping.matchlineups.MatchLineups;
import aglf.service.dto.restmapping.matchlineups.Starting_lineup;
import aglf.service.dto.restmapping.matchsummary.MatchSummary;
import aglf.service.dto.restmapping.team.Player;
import aglf.service.dto.restmapping.team.TeamProfile;
import aglf.service.dto.restmapping.tournamentschedule.Competitor;
import aglf.service.dto.restmapping.tournamentschedule.Sport_event;
import aglf.service.dto.restmapping.tournamentschedule.TournamentSchedule;
import aglf.util.ConstantManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class MigrationUtil {

    private static final Logger logger = Logger.getLogger(MigrationUtil.class);

    @Value("#{'${competitors.list}'.split(',')}")
    private List<String> COMPETITORS_LIST;

    @Autowired
    private RestClient restClient;
    @Autowired
    private TeamDao teamDao;
    @Autowired
    private MatchDao matchDao;
    @Autowired
    private PlayerDao playerDao;
    @Autowired
    private MatchPlayerStatDao matchPlayerStatDao;
    @Autowired
    private UserPlayerDao userPlayerDao;
    @Autowired
    private ScoreHistoryDao scoreHistoryDao;

    public void importTeams() {
        for (String competitorId : COMPETITORS_LIST) {
            coolOffRest(5000);
            TeamProfile teamProfile = restClient.getTeamProfile(competitorId);
            Team team = new Team();
            team.setExternalId(teamProfile.getTeam().getId());
            team.setName(teamProfile.getTeam().getName());
            team.setAbbreviation(teamProfile.getTeam().getAbbreviation());
            team.setCapacity(teamProfile.getVenue().getCapacity());
            team.setCity(teamProfile.getVenue().getCity_name());
            if (teamProfile.getManager() != null) {
                team.setManagerName(teamProfile.getManager().getName());
            }
            for (Player playerInfo : teamProfile.getPlayers()) {
                aglf.data.model.Player player = new aglf.data.model.Player();
                player.setTeam(team);
                player.setExternalId(playerInfo.getId());
                player.setFirstName(playerInfo.getName().split(",")[0].trim());
                if (playerInfo.getName().split(",").length > 1) {
                    player.setLastName(playerInfo.getName().split(",")[1].trim());
                }
                player.setNumber(playerInfo.getJersey_number() != null ? playerInfo.getJersey_number() : 999);
                player.setDateOfBirth(playerInfo.getDate_of_birth());
                if (playerInfo.getType() != null) {
                    switch (playerInfo.getType()) {
                        case "defender":
                            player.setPosition(aglf.data.model.Player.Position.DEFENDER);
                            break;
                        case "midfielder":
                            player.setPosition(aglf.data.model.Player.Position.MIDFILDER);
                            break;
                        case "forward":
                            player.setPosition(aglf.data.model.Player.Position.STRIKER);
                            break;
                        case "goalkeeper":
                            player.setPosition(aglf.data.model.Player.Position.GOALKEEPER);
                            break;
                    }
                }
                player.setPrice(new Random().nextInt(101));
                team.getPlayers().add(player);
            }
            teamDao.save(team);
        }
    }

    private void coolOffRest(int durration) {
        // sleep to cool off rest
        try {
            Thread.sleep(durration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void importMatchSchedule() {
        logger.info("Match imported started");
        TournamentSchedule tournamentSchedule = restClient.getTournamentSchedule();
        int counter = 0;
        for (Sport_event sport_event : tournamentSchedule.getSport_events()) {
            if (matchDao.findByExternalId(sport_event.getId()) != null) {
                continue;
            }
            counter++;

            Match match = new Match();
            match.setExternalId(sport_event.getId());
            try {
                match.setMatchTime(ConstantManager.SPORT_RADAR_DATE_FORMAT.parse(sport_event.getScheduled()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            match.setRound(sport_event.getTournament_round().getNumber());
            for (Competitor competitor : sport_event.getCompetitors()) {
                Team team = teamDao.findByExternalId(competitor.getId());
                if (competitor.getQualifier().equals("home")) {
                    match.setHomeTeam(team);
                } else {
                    match.setGuestTeam(team);
                }
            }
            matchDao.save(match);
            logger.info("Match successfully imported: " + sport_event.getId());
        }
        logger.info("Match imported finished. New imported matches count: " + counter);
    }

    public void scoreMatch(String matchId) {
        logger.info("Starting match scoring for matchId: " + matchId);
        Match match = matchDao.findByExternalId(matchId);
        if (match == null) {
            throw new IllegalStateException("Match not found");
        }
        // Get initial data
        coolOffRest(2000);
        MatchSummary matchSummary = restClient.getMatchSummary(matchId);
        coolOffRest(5000);
        MatchLineups matchLineups = restClient.getMatchLineups(matchId);

        // check if event is closed / finished
        if (matchSummary.getSport_event_status() == null || matchSummary.getSport_event_status().getStatus() == null ||
                !matchSummary.getSport_event_status().getStatus().equals("closed")) {
            logger.info("Skipping scoring because match is not finished");
            return;
        }

        match.setGuestTeamScore(matchSummary.getSport_event_status().getAway_score());
        match.setHomeTeamScore(matchSummary.getSport_event_status().getHome_score());
        match.setCalculated(true);

        Date now = new Date();

        // Import stat and calculate score
        for (aglf.service.dto.restmapping.matchsummary.Team team : matchSummary.getStatistics().getTeams()) {
            logger.info("Starting team scoring for team: " + team.getId());
            for (aglf.service.dto.restmapping.matchsummary.Player playerStat : team.getPlayers()) {
                logger.info("Starting player scoring for player: " + playerStat.getId());

                MatchPlayerStat matchPlayerStat = new MatchPlayerStat();

                aglf.data.model.Player player = playerDao.findByExternalId(playerStat.getId());
                if (player == null) {
                    logger.info("Player not found, skipping score calculation. Player id: " + playerStat.getId());
                    continue;
                }
                // set initial data
                matchPlayerStat.setMatch(match);
                matchPlayerStat.setPlayer(player);
                matchPlayerStat.setCalculated(true);

                // set stat data
                boolean isPlayerStarter = isPlayerStarter(matchLineups, playerStat);
                matchPlayerStat.setStarter(isPlayerStarter);
                // this is all data we can get from this rest
                matchPlayerStat.setSubstitutedIn(getBooleanValue(playerStat.getSubstituted_in()));
                matchPlayerStat.setSubstitutedOut(getBooleanValue(playerStat.getSubstituted_out()));
                matchPlayerStat.setAssists(playerStat.getAssists());
                matchPlayerStat.setGoalsScored(playerStat.getGoals_scored());
                matchPlayerStat.setYellowCards(playerStat.getYellow_cards());
                matchPlayerStat.setYellowRedCards(playerStat.getYellow_red_cards());
                matchPlayerStat.setRedCards(playerStat.getRed_cards());

                // calculate score
                int score = 0;
                // playing 90min (because we dont have data for 60min)
                if (isPlayerStarter && !matchPlayerStat.getSubstitutedOut()) {
                    score += 2;
                }
                // playing up to 90 min
                if ((isPlayerStarter && matchPlayerStat.getSubstitutedOut()) || (!isPlayerStarter && matchPlayerStat.getSubstitutedOut())) {
                    score += 1;
                }
                // scoring a goal
                if (matchPlayerStat.getGoalsScored() != null) {
                    switch (player.getPosition()) {
                        case MIDFILDER:
                            score += matchPlayerStat.getGoalsScored() * 5;
                            break;
                        case STRIKER:
                            score += matchPlayerStat.getGoalsScored() * 4;
                            break;
                        // for goalkeeper and defender
                        default:
                            score += matchPlayerStat.getGoalsScored() * 6;
                            break;
                    }
                }
                // making an assist
                if (matchPlayerStat.getAssists() != null) {
                    score += matchPlayerStat.getAssists();
                }
                // yellow card
                if (1 == matchPlayerStat.getYellowCards()) {
                    score -= 1;
                }

                // red card
                if (1 == matchPlayerStat.getYellowRedCards() || 1 == matchPlayerStat.getRedCards()) {
                    score -= 3;
                }
                // own goal
                if (matchPlayerStat.getOwnGoals() != null) {
                    score -= matchPlayerStat.getOwnGoals() * 2;
                }

                // save score
                matchPlayerStat.setScore(score);
                matchPlayerStatDao.save(matchPlayerStat);

                // update score for all players
                List<UserPlayer> userPlayerList = userPlayerDao.findAllActivePlayers(player);
                if (userPlayerList != null && !userPlayerList.isEmpty()) {
                    for (UserPlayer userPlayer : userPlayerList) {
                        // double score for captain
                        int playerScore = score;
                        if (userPlayer.isCaptain()) {
                            playerScore = playerScore * 2;
                        }
                        // add score to player
                        userPlayer.getUser().addScore(playerScore);
                        // save score history
                        ScoreHistory scoreHistory = new ScoreHistory();
                        scoreHistory.setScore(playerScore);
                        scoreHistory.setDatum(now);
                        scoreHistory.setMatchPlayerStat(matchPlayerStat);
                        scoreHistory.setUser(userPlayer.getUser());
                        scoreHistoryDao.save(scoreHistory);
                    }
                }
            }
        }
        logger.info("Finished scoring for matchId: " + matchId);
    }

    private boolean isPlayerStarter(MatchLineups matchLineups, aglf.service.dto.restmapping.matchsummary.Player player) {
        for (Lineup lineup : matchLineups.getLineups()) {
            for (Starting_lineup starting_lineup : lineup.getStarting_lineup()) {
                if (starting_lineup.getId() != null && starting_lineup.getId().equals(player.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean getBooleanValue(Integer value) {
        return value != null && value == 1;
    }

    public void startMatchScoring() {
        List<Match> matchesForScoring = matchDao.findAllForScoring();
        if (matchesForScoring != null && !matchesForScoring.isEmpty()) {
            logger.info("Found matches for scoring, match number: " + matchesForScoring.size());
            for (Match match : matchesForScoring) {
                scoreMatch(match.getExternalId());
            }
        } else {
            logger.info("Found no matches for scoring");
        }
    }
}
