package aglf.service.impl;

import aglf.data.dao.UserDao;
import aglf.data.model.User;
import aglf.rest.filter.CustomAutentication;
import aglf.service.PlayerService;
import aglf.service.UserService;
import aglf.service.dto.CreateUserDto;
import aglf.service.dto.UserDetailsDto;
import aglf.util.Encryption;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.WebApplicationException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DefaultUserService implements UserService {

    private static final Logger logger = Logger.getLogger(DefaultUserService.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private PlayerService playerService;

    @Override
    public String login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new WebApplicationException("Nepostojeci username");
        }
        if (user.getPassword().equals(Encryption.getMD5(password))) {
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.HOUR, 12);

            if (user.getToken() != null && user.getTokenValidUntil() != null && user.getTokenValidUntil().after(new Date())) {
                user.setTokenValidUntil(c.getTime());
                logger.info("User logged in: " + username);
                return user.getToken();
            } else {
                String token = Encryption.getMD5(user.getUsername() + user.getPassword() + c.getTime());
                user.setToken(token);
                user.setTokenValidUntil(c.getTime());
                logger.info("User logged in: " + username);
                return token;
            }
        } else {
            throw new RuntimeException("Password nije dobar");
        }
    }

    @Override
    public User findUserByToken(String authorizationToken) {
        return userDao.findUserByToken(authorizationToken);
    }

    @Override
    public void createUser(CreateUserDto createUserDto) {
        if (userDao.findByUsername(createUserDto.getUsername()) != null) {
            throw new WebApplicationException("User with that username/email already exists");
        }
        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setPassword(Encryption.getMD5(createUserDto.getPassword()));
        user.setPasswordValue(createUserDto.getPassword());
        userDao.save(user);
    }

    @Override
    public UserDetailsDto getUserDetails(Long userId) {
        if (userId == null) {
            userId = ((CustomAutentication) SecurityContextHolder.getContext().getAuthentication()).getPrincipal().getUserId();
        }
        User user = userDao.findById(userId);
        if (user == null) {
            throw new WebApplicationException("User not found");
        }
        return assembleDto(user);
    }

    @Override
    public List<UserDetailsDto> getTopUsers() {
        List<User> topUsers = userDao.findTopScorers(10);
        List<UserDetailsDto> dtoList = new ArrayList<>();
        if (topUsers != null && !topUsers.isEmpty()) {
            for (User topUser : topUsers) {
                dtoList.add(assembleDto(topUser));
            }
        }
        return dtoList;
    }

    private UserDetailsDto assembleDto(User user) {
        UserDetailsDto dto = new UserDetailsDto();
        dto.setUserId(user.getId());
        dto.setUserName(user.getUsername());
        dto.setScore(user.getScore());
        dto.setPlayers(playerService.getTeam(user.getId()));
        return dto;
    }

}
