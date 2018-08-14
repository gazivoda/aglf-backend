package aglf.data.dao;

import aglf.data.dao.commons.AbstractDao;
import aglf.data.model.Team;

public interface TeamDao extends AbstractDao<Long, Team> {

    Team findByExternalId(String externalId);

}
