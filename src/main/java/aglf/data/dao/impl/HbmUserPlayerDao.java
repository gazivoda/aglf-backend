package aglf.data.dao.impl;

import aglf.data.dao.UserPlayerDao;
import aglf.data.dao.commons.HbmGenericDaoBase;
import aglf.data.model.Player;
import aglf.data.model.UserPlayer;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class HbmUserPlayerDao extends HbmGenericDaoBase<Long, UserPlayer> implements UserPlayerDao {

    public HbmUserPlayerDao() {
        super(UserPlayer.class);
    }

    @Override
    public List<UserPlayer> findAllActivePlayers(Player player) {
        String hql = "from UserPlayer where player = :player and active = true";
        Query query = getSession().createQuery(hql);
        query.setEntity("player", player);
        return query.list();
    }
}
