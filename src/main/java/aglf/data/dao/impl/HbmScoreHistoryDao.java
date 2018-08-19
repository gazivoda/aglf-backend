package aglf.data.dao.impl;

import aglf.data.dao.ScoreHistoryDao;
import aglf.data.dao.commons.HbmGenericDaoBase;
import aglf.data.model.Player;
import aglf.data.model.ScoreHistory;
import aglf.data.model.UserPlayer;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class HbmScoreHistoryDao extends HbmGenericDaoBase<Long, ScoreHistory> implements ScoreHistoryDao {

    public HbmScoreHistoryDao() {
        super(ScoreHistory.class);
    }
}
