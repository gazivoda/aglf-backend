package aglf.rest.impl;

import aglf.rest.UserRest;
import aglf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRestImpl implements UserRest {

    @Autowired
    private UserService userService;

    @Override
    public String login(String username, String password) {
        return userService.login(username, password);
    }

}
