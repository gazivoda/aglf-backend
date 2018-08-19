package aglf.data.dao.impl;

import aglf.data.dao.PlayerDao;
import aglf.data.dao.commons.HbmGenericDaoBase;
import aglf.data.model.Player;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


@Repository
public class HbmPlayerDao extends HbmGenericDaoBase<Long, Player> implements PlayerDao {

    public HbmPlayerDao() {
        super(Player.class);
    }

    @Override
    public Player findByExternalId(String externalId) {
        String hql = "from Player where externalId = :externalId";
        Query query = getSession().createQuery(hql);
        query.setString("externalId", externalId);
        return (Player) query.uniqueResult();
    }
}
