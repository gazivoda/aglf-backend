package aglf.data.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pc_user")
//Override the default Hibernation delete and set the deleted flag rather than deleting the record from the db.
@SQLDelete(sql = "UPDATE pc_user SET deleted = '1' WHERE id = ?")
//Filter added to retrieve only records that have not been soft deleted.
@Where(clause = "deleted <> '1'")
@NamedQueries({
        @NamedQuery(name = "PcUser.findAll", query = "SELECT p FROM User p"),
        @NamedQuery(name = "PcUser.findById", query = "SELECT p FROM User p WHERE p.id = :id"),
        @NamedQuery(name = "PcUser.findByUsername", query = "SELECT p FROM User p WHERE p.username = :username"),
        @NamedQuery(name = "PcUser.findByToken", query = "SELECT p FROM User p WHERE p.token = :token"),
        @NamedQuery(name = "PcUser.findByTokenValidUntil", query = "SELECT p FROM User p WHERE p.tokenValidUntil = :tokenValidUntil")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 255)
    @Column(name = "token")
    private String token;
    @Column(name = "token_valid_until")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tokenValidUntil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "deleted")
    private char deleted = '0';
    @NotNull
    @Size(max = 255)
    @Column(name = "password_value")
    private String passwordValue;
    @Column(name = "price", nullable = false)
    private Long score = 0L;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private Set<UserPlayer> userPlayers;


    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenValidUntil() {
        return tokenValidUntil;
    }

    public void setTokenValidUntil(Date tokenValidUntil) {
        this.tokenValidUntil = tokenValidUntil;
    }

    public char getDeleted() {
        return deleted;
    }

    public void setDeleted(char deleted) {
        this.deleted = deleted;
    }

    public String getPasswordValue() {
        return passwordValue;
    }

    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }

    public Set<UserPlayer> getUserPlayers() {
        return userPlayers;
    }

    public void setUserPlayers(Set<UserPlayer> userPlayers) {
        this.userPlayers = userPlayers;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.User[ id=" + id + " ]";
    }

}
