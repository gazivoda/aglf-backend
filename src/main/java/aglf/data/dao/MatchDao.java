package aglf.data.dao;

import aglf.data.dao.commons.AbstractDao;
import aglf.data.model.Match;

import java.util.List;

public interface MatchDao extends AbstractDao<Long, Match> {

    Match findByExternalId(String externalId);

    List<Match> findAllForScoring();

}
