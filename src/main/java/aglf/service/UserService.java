package aglf.service;

import aglf.data.model.User;

public interface UserService {

    String login(String username, String password);

    User findUserByToken(String authorizationToken);

}
