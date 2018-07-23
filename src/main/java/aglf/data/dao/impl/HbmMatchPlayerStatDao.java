package aglf.data.dao.impl;

import aglf.data.dao.MatchPlayerStatDao;
import aglf.data.dao.commons.HbmGenericDaoBase;
import aglf.data.model.MatchPlayerStat;
import org.springframework.stereotype.Repository;


@Repository
public class HbmMatchPlayerStatDao extends HbmGenericDaoBase<Long, MatchPlayerStat> implements MatchPlayerStatDao {

    public HbmMatchPlayerStatDao() {
        super(MatchPlayerStat.class);
    }

}
