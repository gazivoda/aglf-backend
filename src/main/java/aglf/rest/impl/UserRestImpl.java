package aglf.rest.impl;

import aglf.rest.UserRest;
import aglf.service.UserService;
import aglf.service.dto.CreateUserDto;
import aglf.service.dto.UserAndPassDto;
import aglf.service.dto.UserDetailsDto;
import aglf.service.dto.UserTokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRestImpl implements UserRest {

    @Autowired
    private UserService userService;

    @Override
    public UserTokenDto login(UserAndPassDto dto) {
        return new UserTokenDto(userService.login(dto.getUsername(), dto.getPassword()));
    }

    @Override
    public UserTokenDto signUp(CreateUserDto createUserDto) {
        userService.createUser(createUserDto);
        return new UserTokenDto(userService.login(createUserDto.getUsername(), createUserDto.getPassword()));
    }

    @Override
    public UserDetailsDto getUserDetails(Long userId) {
        return userService.getUserDetails(userId);
    }

    @Override
    public List<UserDetailsDto> getTopUsers() {
        return userService.getTopUsers();
    }

    @Override
    public List<UserDetailsDto> getProgressForUser(Long userId) {
        return userService.getProgressForUser(userId);
    }

}
