package aglf.data.dao.impl;

import aglf.data.dao.PlayerDao;
import aglf.data.dao.commons.HbmGenericDaoBase;
import aglf.data.model.Player;
import aglf.service.dto.TopPlayersDto;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class HbmPlayerDao extends HbmGenericDaoBase<Long, Player> implements PlayerDao {

    public HbmPlayerDao() {
        super(Player.class);
    }

    @Override
    public Player findByExternalId(String externalId) {
        String hql = "from Player where externalId = :externalId";
        Query query = getSession().createQuery(hql);
        query.setString("externalId", externalId);
        return (Player) query.uniqueResult();
    }

    @Override
    public List<TopPlayersDto> getTopPlayers() {
        String sql = "select p.id as playerId, " +
                "p.first_name as firstName, " +
                "p.last_name as lastName, " +
                "p.price as price, " +
                "t.`name` as teamName, " +
                "t.id as teamId, " +
                "t.jersey_url as jerseyUrl, " +
                "SUM(ms.score) as score " +
                "from pc_match_stat ms " +
                "join pc_player p on ms.player_id = p.id " +
                "join pc_team t on p.team_id = t.id " +
                "GROUP BY p.id " +
                "ORDER BY score DESC";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addScalar("playerId", LongType.INSTANCE);
        query.addScalar("firstName", StringType.INSTANCE);
        query.addScalar("lastName", StringType.INSTANCE);
        query.addScalar("teamName", StringType.INSTANCE);
        query.addScalar("score", IntegerType.INSTANCE);
        query.addScalar("teamId", LongType.INSTANCE);
        query.addScalar("jerseyUrl", StringType.INSTANCE);
        query.addScalar("price", IntegerType.INSTANCE);
        query.setResultTransformer(Transformers.aliasToBean(TopPlayersDto.class));
        return query.list();
    }

    @Override
    public List<TopPlayersDto> getTopPlayersPerRound(int round) {
        String sql = "select p.id as playerId, " +
                "p.first_name as firstName, " +
                "p.last_name as lastName, " +
                "p.price as price, " +
                "t.`name` as teamName, " +
                "t.id as teamId, " +
                "t.jersey_url as jerseyUrl, " +
                "SUM(ms.score) as score " +
                "from pc_match_stat ms " +
                "join pc_player p on ms.player_id = p.id " +
                "join pc_team t on p.team_id = t.id " +
                "join pc_match m on ms.match_id = m.id " +
                "where round = :round " +
                "GROUP BY p.id " +
                "ORDER BY score DESC";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addScalar("playerId", LongType.INSTANCE);
        query.addScalar("firstName", StringType.INSTANCE);
        query.addScalar("lastName", StringType.INSTANCE);
        query.addScalar("teamName", StringType.INSTANCE);
        query.addScalar("score", IntegerType.INSTANCE);
        query.setInteger("round", round);
        query.addScalar("teamId", LongType.INSTANCE);
        query.addScalar("jerseyUrl", StringType.INSTANCE);
        query.addScalar("price", IntegerType.INSTANCE);
        query.setResultTransformer(Transformers.aliasToBean(TopPlayersDto.class));
        return query.list();
    }

}
