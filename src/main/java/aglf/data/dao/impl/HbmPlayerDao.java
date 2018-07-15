package aglf.data.dao.impl;

import aglf.data.dao.PlayerDao;
import aglf.data.dao.commons.HbmGenericDaoBase;
import aglf.data.model.Player;
import org.springframework.stereotype.Repository;


@Repository
public class HbmPlayerDao extends HbmGenericDaoBase<Long, Player> implements PlayerDao {

    public HbmPlayerDao() {
        super(Player.class);
    }

}
