package aglf.service;

import aglf.data.model.User;
import aglf.service.dto.CreateUserDto;
import aglf.service.dto.UserDetailsDto;

import java.util.List;

public interface UserService {

    String login(String username, String password);

    User findUserByToken(String authorizationToken);

    void createUser(CreateUserDto createUserDto);

    UserDetailsDto getUserDetails(Long userId);

    List<UserDetailsDto> getTopUsers();

}
