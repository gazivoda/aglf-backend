package aglf.service.dto;

public class UserTokenDto {

    private String token;

    public UserTokenDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
