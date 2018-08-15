package aglf.migration;

import aglf.data.dao.MatchDao;
import aglf.data.dao.TeamDao;
import aglf.data.model.Match;
import aglf.data.model.Team;
import aglf.service.RestClient;
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

    public void importTeams() {
        for (String competitorId : COMPETITORS_LIST) {
            // sleep to cool off rest
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

}
