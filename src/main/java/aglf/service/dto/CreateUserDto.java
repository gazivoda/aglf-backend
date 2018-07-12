package aglf.service.dto;

public class CreateUserDto {

    private Long userId;
    private String username;
    private String ime;
    private String prezime;
    private Long poslovnaJedinicaId;
    private String password;
    private String userType;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Long getPoslovnaJedinicaId() {
        return poslovnaJedinicaId;
    }

    public void setPoslovnaJedinicaId(Long poslovnaJedinicaId) {
        this.poslovnaJedinicaId = poslovnaJedinicaId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
