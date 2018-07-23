package aglf.data.dao.impl;

import aglf.data.dao.MatchDao;
import aglf.data.dao.TeamDao;
import aglf.data.dao.commons.HbmGenericDaoBase;
import aglf.data.model.Match;
import aglf.data.model.Team;
import org.springframework.stereotype.Repository;


@Repository
public class HbmMatchDao extends HbmGenericDaoBase<Long, Match> implements MatchDao {

    public HbmMatchDao() {
        super(Match.class);
    }

}
