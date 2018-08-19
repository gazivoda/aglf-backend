package aglf.rest.impl;

import aglf.rest.UserRest;
import aglf.service.UserService;
import aglf.service.dto.CreateUserDto;
import aglf.service.dto.UserAndPassDto;
import aglf.service.dto.UserTokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

}
