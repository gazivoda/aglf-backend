package aglf.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pc_user_player")
public class UserPlayer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "captain", nullable = false)
    private boolean captain;
    @Column(name = "vice_captain", nullable = false)
    private boolean viceCaptain;
    @Column(name = "active", nullable = false)
    private boolean active;
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Player player;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCaptain() {
        return captain;
    }

    public void setCaptain(boolean captain) {
        this.captain = captain;
    }

    public boolean isViceCaptain() {
        return viceCaptain;
    }

    public void setViceCaptain(boolean viceCaptain) {
        this.viceCaptain = viceCaptain;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int result = player.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPlayer that = (UserPlayer) o;

        if (!player.equals(that.player)) return false;
        return user.equals(that.user);

    }
}
