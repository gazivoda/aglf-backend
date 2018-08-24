package aglf.data.dao.impl;

import aglf.data.dao.UserDao;
import aglf.data.dao.commons.HbmGenericDaoBase;
import aglf.data.model.User;
import aglf.service.dto.UserDetailsDto;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
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

    @Override
    public List<UserDetailsDto> getProgressForUser(Long userId) {
        String sql = "select u.id as userId, " +
                "u.username as userName, " +
                "m.round as round, " +
                "SUM(sh.score) as score " +
                "from pc_match_stat ms " +
                "join pc_match m on ms.match_id = m.id " +
                "join pc_score_history sh on ms.id = sh.match_stat_id " +
                "join pc_user u on sh.user_id = u.id " +
                "where sh.user_id = :userId " +
                "GROUP BY m.round";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addScalar("userId", LongType.INSTANCE);
        query.addScalar("userName", StringType.INSTANCE);
        query.addScalar("round", IntegerType.INSTANCE);
        query.addScalar("score", IntegerType.INSTANCE);
        query.setLong("userId", userId);
        query.setResultTransformer(Transformers.aliasToBean(UserDetailsDto.class));
        return query.list();
    }
}
