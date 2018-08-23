package aglf.data.dao.impl;

import aglf.data.dao.UserDao;
import aglf.data.dao.commons.HbmGenericDaoBase;
import aglf.data.model.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class HbmUserDao extends HbmGenericDaoBase<Long, User> implements UserDao {

    public HbmUserDao() {
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
        String hql = "from User where username = :username";
        Query query = getSession().createQuery(hql);
        query.setString("username", username);
        return (User) query.uniqueResult();
    }

    @Override
    public User findUserByToken(String authorizationToken) {
        String hql = "from User where token = :token";
        Query query = getSession().createQuery(hql);
        query.setString("token", authorizationToken);
        return (User) query.uniqueResult();
    }

    @Override
    public List<User> findTopScorers(int limit) {
        String hql = "from User order by score desc ";
        Query query = getSession().createQuery(hql);
        query.setMaxResults(limit);
        return query.list();
    }
}
