package aglf.data.dao;

import aglf.data.dao.commons.AbstractDao;
import aglf.data.model.Match;
import aglf.data.model.MatchPlayerStat;

public interface MatchPlayerStatDao extends AbstractDao<Long, MatchPlayerStat> {

    MatchPlayerStat findByMatch(Match match);

    Integer findLatestScoredRound();
}
