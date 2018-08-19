package aglf.data.dao;

import aglf.data.dao.commons.AbstractDao;
import aglf.data.model.Player;
import aglf.data.model.UserPlayer;

import java.util.List;

public interface UserPlayerDao extends AbstractDao<Long, UserPlayer> {

    List<UserPlayer> findAllActivePlayers(Player player);

}
