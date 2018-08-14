package aglf.data.dao.impl;

import aglf.data.dao.TeamDao;
import aglf.data.dao.commons.HbmGenericDaoBase;
import aglf.data.model.Team;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


@Repository
public class HbmTeamDao extends HbmGenericDaoBase<Long, Team> implements TeamDao {

    public HbmTeamDao() {
        super(Team.class);
    }

    @Override
    public Team findByExternalId(String externalId) {
        String hql = "from Team where externalId = :externalId";
        Query query = getSession().createQuery(hql);
        query.setString("externalId", externalId);
        return (Team) query.uniqueResult();
    }
}
