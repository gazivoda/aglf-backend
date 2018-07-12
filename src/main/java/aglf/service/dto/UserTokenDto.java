package aglf.service.dto;

public class UserTokenDto {

    private String token;
    private Long userTypeId;
    private String userType;

    public UserTokenDto(String token, Long userTypeId, String userType) {
        this.token = token;
        this.userTypeId = userTypeId;
        this.userType = userType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
