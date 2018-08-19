package aglf.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pc_score_history")
public class ScoreHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "match_stat_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MatchPlayerStat matchPlayerStat;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Column(name = "score")
    private Integer score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MatchPlayerStat getMatchPlayerStat() {
        return matchPlayerStat;
    }

    public void setMatchPlayerStat(MatchPlayerStat matchPlayerStat) {
        this.matchPlayerStat = matchPlayerStat;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ScoreHistory)) {
            return false;
        }
        ScoreHistory other = (ScoreHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
