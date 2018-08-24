package aglf.data.dao;

import aglf.data.dao.commons.AbstractDao;
import aglf.data.model.User;
import aglf.service.dto.UserDetailsDto;

import java.util.List;

public interface UserDao extends AbstractDao<Long, User> {

    User findByUsername(String username);

    User findUserByToken(String authorizationToken);

    List<User> findTopScorers(int limit);

    List<UserDetailsDto> getProgressForUser(Long userId);
}
