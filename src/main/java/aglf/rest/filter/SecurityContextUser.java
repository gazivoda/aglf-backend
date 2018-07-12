package aglf.rest.filter;

import java.security.Principal;

public class SecurityContextUser implements Principal {

    private Long userId;

    public SecurityContextUser(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getName() {
        return userId.toString();
    }
}
