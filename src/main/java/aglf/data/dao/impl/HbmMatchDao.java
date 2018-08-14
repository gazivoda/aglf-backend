package aglf.data.dao.impl;

import aglf.data.dao.MatchDao;
import aglf.data.dao.commons.HbmGenericDaoBase;
import aglf.data.model.Match;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


@Repository
public class HbmMatchDao extends HbmGenericDaoBase<Long, Match> implements MatchDao {

    public HbmMatchDao() {
        super(Match.class);
    }

    @Override
    public Match findByExternalId(String externalId) {
        String hql = "from Match where externalId = :externalId";
        Query query = getSession().createQuery(hql);
        query.setString("externalId", externalId);
        return (Match) query.uniqueResult();
    }
}
