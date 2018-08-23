package aglf.data.dao;

import aglf.data.dao.commons.AbstractDao;
import aglf.data.model.Player;
import aglf.service.dto.TopPlayersDto;

import java.util.List;

public interface PlayerDao extends AbstractDao<Long, Player> {

    Player findByExternalId(String externalId);

    List<TopPlayersDto> getTopPlayers();

    List<TopPlayersDto> getTopPlayersPerRound(int round);
}
