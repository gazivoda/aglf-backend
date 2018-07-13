package aglf.service.impl;

import aglf.data.dao.UserDao;
import aglf.data.model.User;
import aglf.service.UserService;
import aglf.service.dto.CreateUserDto;
import aglf.util.Encryption;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.WebApplicationException;
import java.util.Calendar;
import java.util.Date;

@Service
@Transactional
public class DefaultUserService implements UserService {

    private static final Logger logger = Logger.getLogger(DefaultUserService.class);

    @Autowired
    private UserDao userDao;

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
        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setPassword(Encryption.getMD5(createUserDto.getPassword()));
        user.setPasswordValue(createUserDto.getPassword());
        userDao.save(user);
    }

    private User saveUser(CreateUserDto createUserDto, Long userType) {
        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setPassword(Encryption.getMD5(createUserDto.getPassword()));
        user.setPasswordValue(createUserDto.getPassword());
        userDao.save(user);
        return user;
    }

}
