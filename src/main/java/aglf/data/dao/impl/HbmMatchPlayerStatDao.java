package aglf.data.dao.impl;

import aglf.data.dao.MatchPlayerStatDao;
import aglf.data.dao.commons.HbmGenericDaoBase;
import aglf.data.model.Match;
import aglf.data.model.MatchPlayerStat;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


@Repository
public class HbmMatchPlayerStatDao extends HbmGenericDaoBase<Long, MatchPlayerStat> implements MatchPlayerStatDao {

    public HbmMatchPlayerStatDao() {
        super(MatchPlayerStat.class);
    }

    @Override
    public MatchPlayerStat findByMatch(Match match) {
        String hql = "from MatchPlayerStat where match = :match";
        Query query = getSession().createQuery(hql);
        query.setEntity("match", match);
        return (MatchPlayerStat) query.list();
    }

    @Override
    public Integer findLatestScoredRound() {
        String hql = "select max(round) from Match where calculated = true";
        Query query = getSession().createQuery(hql);
        return (Integer) query.uniqueResult();
    }
}
