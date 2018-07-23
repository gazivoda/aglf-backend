package aglf.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pc_match_stat")
public class MatchPlayerStat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "match_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Match match;
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Player player;
    @Column(name = "calculated", nullable = false)
    private boolean calculated;
    @Column(name = "score")
    private Double score;

    // FIELDS FED FROM API
    @Column(name = "assists")
    private Integer assists;
    @Column(name = "chances_created")
    private Integer chancesCreated;
    @Column(name = "crosses_successful")
    private Integer crossesSuccessful;
    @Column(name = "crosses_total")
    private Integer crossesTotal;
    @Column(name = "duels_header_successful")
    private Integer duelsHeaderSuccessful;
    @Column(name = "duels_header_total")
    private Integer duelsHeaderTotal;
    @Column(name = "duels_sprint_successful")
    private Integer duelsSprintSuccessful;
    @Column(name = "duels_sprint_total")
    private Integer duelsSprintTotal;
    @Column(name = "duels_tackle_successful")
    private Integer duelsTackleSuccessful;
    @Column(name = "duels_tackle_total")
    private Integer duelsTackleTotal;
    @Column(name = "fouls_committed")
    private Integer foulsCommitted;
    @Column(name = "goal_line_clearances")
    private Integer goalLineClearances;
    @Column(name = "goals_by_head")
    private Integer goalsByHead;
    @Column(name = "goals_by_penalty")
    private Integer goalsByPenalty;
    @Column(name = "goals_conceded")
    private Integer goalsConceded;
    @Column(name = "goals_scored")
    private Integer goalsScored;
    @Column(name = "interceptions")
    private Integer interceptions;
    @Column(name = "minutes_played")
    private Integer minutesPlayed;
    @Column(name = "offsides")
    private Integer offsides;
    @Column(name = "own_goals")
    private Integer ownGoals;
    @Column(name = "passes_long_successful")
    private Integer passesLongSuccessful;
    @Column(name = "passes_long_total")
    private Integer passesLongTotal;
    @Column(name = "passes_medium_successful")
    private Integer passesMediumSuccessful;
    @Column(name = "passes_medium_total")
    private Integer passesMediumTotal;
    @Column(name = "passes_short_successful")
    private Integer passesShortSuccessful;
    @Column(name = "passes_short_total")
    private Integer passesShortTotal;
    @Column(name = "penalties_faced")
    private Integer penaltiesFaced;
    @Column(name = "penalties_missed")
    private Integer penaltiesMissed;
    @Column(name = "penalties_saved")
    private Integer penaltiesSaved;
    @Column(name = "performance_score")
    private Integer performanceScore;
    @Column(name = "red_cards")
    private Integer redCards;
    @Column(name = "shots_blocked")
    private Integer shotsBlocked;
    @Column(name = "shots_faced_saved")
    private Integer shotsFacedSaved;
    @Column(name = "shots_faced_total")
    private Integer shotsFacedTotal;
    @Column(name = "shots_off_goal")
    private Integer shotsOffGoal;
    @Column(name = "shots_on_goal")
    private Integer shotsOnGoal;
    @Column(name = "substituted_in")
    private Boolean substitutedIn;
    @Column(name = "substituted_out")
    private Boolean substitutedOut;
    @Column(name = "was_fouled")
    private Boolean wasFouled;
    @Column(name = "yellow_cards")
    private Integer yellowCards;
    @Column(name = "yellow_red_cards")
    private Integer yellowRedCards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isCalculated() {
        return calculated;
    }

    public void setCalculated(boolean calculated) {
        this.calculated = calculated;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getChancesCreated() {
        return chancesCreated;
    }

    public void setChancesCreated(Integer chancesCreated) {
        this.chancesCreated = chancesCreated;
    }

    public Integer getCrossesSuccessful() {
        return crossesSuccessful;
    }

    public void setCrossesSuccessful(Integer crossesSuccessful) {
        this.crossesSuccessful = crossesSuccessful;
    }

    public Integer getCrossesTotal() {
        return crossesTotal;
    }

    public void setCrossesTotal(Integer crossesTotal) {
        this.crossesTotal = crossesTotal;
    }

    public Integer getDuelsHeaderSuccessful() {
        return duelsHeaderSuccessful;
    }

    public void setDuelsHeaderSuccessful(Integer duelsHeaderSuccessful) {
        this.duelsHeaderSuccessful = duelsHeaderSuccessful;
    }

    public Integer getDuelsHeaderTotal() {
        return duelsHeaderTotal;
    }

    public void setDuelsHeaderTotal(Integer duelsHeaderTotal) {
        this.duelsHeaderTotal = duelsHeaderTotal;
    }

    public Integer getDuelsSprintSuccessful() {
        return duelsSprintSuccessful;
    }

    public void setDuelsSprintSuccessful(Integer duelsSprintSuccessful) {
        this.duelsSprintSuccessful = duelsSprintSuccessful;
    }

    public Integer getDuelsSprintTotal() {
        return duelsSprintTotal;
    }

    public void setDuelsSprintTotal(Integer duelsSprintTotal) {
        this.duelsSprintTotal = duelsSprintTotal;
    }

    public Integer getDuelsTackleSuccessful() {
        return duelsTackleSuccessful;
    }

    public void setDuelsTackleSuccessful(Integer duelsTackleSuccessful) {
        this.duelsTackleSuccessful = duelsTackleSuccessful;
    }

    public Integer getDuelsTackleTotal() {
        return duelsTackleTotal;
    }

    public void setDuelsTackleTotal(Integer duelsTackleTotal) {
        this.duelsTackleTotal = duelsTackleTotal;
    }

    public Integer getFoulsCommitted() {
        return foulsCommitted;
    }

    public void setFoulsCommitted(Integer foulsCommitted) {
        this.foulsCommitted = foulsCommitted;
    }

    public Integer getGoalLineClearances() {
        return goalLineClearances;
    }

    public void setGoalLineClearances(Integer goalLineClearances) {
        this.goalLineClearances = goalLineClearances;
    }

    public Integer getGoalsByHead() {
        return goalsByHead;
    }

    public void setGoalsByHead(Integer goalsByHead) {
        this.goalsByHead = goalsByHead;
    }

    public Integer getGoalsByPenalty() {
        return goalsByPenalty;
    }

    public void setGoalsByPenalty(Integer goalsByPenalty) {
        this.goalsByPenalty = goalsByPenalty;
    }

    public Integer getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(Integer goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public Integer getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(Integer goalsScored) {
        this.goalsScored = goalsScored;
    }

    public Integer getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(Integer interceptions) {
        this.interceptions = interceptions;
    }

    public Integer getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(Integer minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public Integer getOffsides() {
        return offsides;
    }

    public void setOffsides(Integer offsides) {
        this.offsides = offsides;
    }

    public Integer getOwnGoals() {
        return ownGoals;
    }

    public void setOwnGoals(Integer ownGoals) {
        this.ownGoals = ownGoals;
    }

    public Integer getPassesLongSuccessful() {
        return passesLongSuccessful;
    }

    public void setPassesLongSuccessful(Integer passesLongSuccessful) {
        this.passesLongSuccessful = passesLongSuccessful;
    }

    public Integer getPassesLongTotal() {
        return passesLongTotal;
    }

    public void setPassesLongTotal(Integer passesLongTotal) {
        this.passesLongTotal = passesLongTotal;
    }

    public Integer getPassesMediumSuccessful() {
        return passesMediumSuccessful;
    }

    public void setPassesMediumSuccessful(Integer passesMediumSuccessful) {
        this.passesMediumSuccessful = passesMediumSuccessful;
    }

    public Integer getPassesMediumTotal() {
        return passesMediumTotal;
    }

    public void setPassesMediumTotal(Integer passesMediumTotal) {
        this.passesMediumTotal = passesMediumTotal;
    }

    public Integer getPassesShortSuccessful() {
        return passesShortSuccessful;
    }

    public void setPassesShortSuccessful(Integer passesShortSuccessful) {
        this.passesShortSuccessful = passesShortSuccessful;
    }

    public Integer getPassesShortTotal() {
        return passesShortTotal;
    }

    public void setPassesShortTotal(Integer passesShortTotal) {
        this.passesShortTotal = passesShortTotal;
    }

    public Integer getPenaltiesFaced() {
        return penaltiesFaced;
    }

    public void setPenaltiesFaced(Integer penaltiesFaced) {
        this.penaltiesFaced = penaltiesFaced;
    }

    public Integer getPenaltiesMissed() {
        return penaltiesMissed;
    }

    public void setPenaltiesMissed(Integer penaltiesMissed) {
        this.penaltiesMissed = penaltiesMissed;
    }

    public Integer getPenaltiesSaved() {
        return penaltiesSaved;
    }

    public void setPenaltiesSaved(Integer penaltiesSaved) {
        this.penaltiesSaved = penaltiesSaved;
    }

    public Integer getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(Integer performanceScore) {
        this.performanceScore = performanceScore;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    public Integer getShotsBlocked() {
        return shotsBlocked;
    }

    public void setShotsBlocked(Integer shotsBlocked) {
        this.shotsBlocked = shotsBlocked;
    }

    public Integer getShotsFacedSaved() {
        return shotsFacedSaved;
    }

    public void setShotsFacedSaved(Integer shotsFacedSaved) {
        this.shotsFacedSaved = shotsFacedSaved;
    }

    public Integer getShotsFacedTotal() {
        return shotsFacedTotal;
    }

    public void setShotsFacedTotal(Integer shotsFacedTotal) {
        this.shotsFacedTotal = shotsFacedTotal;
    }

    public Integer getShotsOffGoal() {
        return shotsOffGoal;
    }

    public void setShotsOffGoal(Integer shotsOffGoal) {
        this.shotsOffGoal = shotsOffGoal;
    }

    public Integer getShotsOnGoal() {
        return shotsOnGoal;
    }

    public void setShotsOnGoal(Integer shotsOnGoal) {
        this.shotsOnGoal = shotsOnGoal;
    }

    public Boolean getSubstitutedIn() {
        return substitutedIn;
    }

    public void setSubstitutedIn(Boolean substitutedIn) {
        this.substitutedIn = substitutedIn;
    }

    public Boolean getSubstitutedOut() {
        return substitutedOut;
    }

    public void setSubstitutedOut(Boolean substitutedOut) {
        this.substitutedOut = substitutedOut;
    }

    public Boolean getWasFouled() {
        return wasFouled;
    }

    public void setWasFouled(Boolean wasFouled) {
        this.wasFouled = wasFouled;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Integer getYellowRedCards() {
        return yellowRedCards;
    }

    public void setYellowRedCards(Integer yellowRedCards) {
        this.yellowRedCards = yellowRedCards;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MatchPlayerStat)) {
            return false;
        }
        MatchPlayerStat other = (MatchPlayerStat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
