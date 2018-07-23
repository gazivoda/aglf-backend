package aglf.data.model;

import javax.persistence.*;
import java.io.Serializable;

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
