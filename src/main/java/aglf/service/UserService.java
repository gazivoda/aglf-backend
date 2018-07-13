package aglf.service;

import aglf.data.model.User;
import aglf.service.dto.CreateUserDto;

public interface UserService {

    String login(String username, String password);

    User findUserByToken(String authorizationToken);

    void createUser(CreateUserDto createUserDto);
}
