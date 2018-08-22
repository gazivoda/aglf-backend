package aglf.data.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pc_match")
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "team_home_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Team homeTeam;
    @JoinColumn(name = "team_guest_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Team guestTeam;
    @Column(name = "home_team_score")
    private Integer homeTeamScore;
    @Column(name = "guest_team_score")
    private Integer guestTeamScore;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date matchTime;
    @Size(max = 255)
    @Column(name = "external_id")
    private String externalId;
    @Column(name = "round")
    private Integer round;
    @Column(name = "calculated", nullable = false)
    private boolean calculated;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Integer getGuestTeamScore() {
        return guestTeamScore;
    }

    public void setGuestTeamScore(Integer guestTeamScore) {
        this.guestTeamScore = guestTeamScore;
    }

    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public boolean isCalculated() {
        return calculated;
    }

    public void setCalculated(boolean calculated) {
        this.calculated = calculated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Match)) {
            return false;
        }
        Match other = (Match) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
