package aglf.service;

import aglf.data.dao.MatchPlayerStatDao;
import aglf.data.dao.PlayerDao;
import aglf.data.dao.UserDao;
import aglf.data.model.Player;
import aglf.data.model.User;
import aglf.data.model.UserPlayer;
import aglf.rest.filter.CustomAutentication;
import aglf.service.assembler.PlayerAssembler;
import aglf.service.dto.PlayerDto;
import aglf.service.dto.TopPlayersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.WebApplicationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayerService {

    @Autowired
    private PlayerDao playerDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private MatchPlayerStatDao matchPlayerStatDao;

    public List<PlayerDto> findAllPlayers() {
        return playerDao.findAll().stream().map(PlayerAssembler::getPlayerDto).collect(Collectors.toList());
    }

    public void setPlayers(List<PlayerDto> players) {
        User user = userDao.findById(((CustomAutentication) SecurityContextHolder.getContext().getAuthentication()).getPrincipal().getUserId());
        if (user == null) {
            throw new WebApplicationException("User not found");
        }

        user.getUserPlayers().clear();
        for (PlayerDto player : players) {

            UserPlayer up = new UserPlayer();
            up.setUser(user);
            up.setPlayer(playerDao.loadById(player.getId()));
            up.setActive(player.getActive() != null ? player.getActive() : false);
            up.setCaptain(player.getCaptain() != null ? player.getCaptain() : false);
            up.setViceCaptain(player.getViceCaptain() != null ? player.getViceCaptain() : false);

            user.getUserPlayers().add(up);

            // validate user list
            if (user.getUserPlayers().size() > 15) {
                throw new WebApplicationException("Number of selected players must be 15");
            }
            if (user.getUserPlayers().stream().filter(UserPlayer::isActive).count() > 11) {
                throw new WebApplicationException("Number of active players must be 11");
            }
            if (user.getUserPlayers().stream().filter(UserPlayer::isCaptain).count() > 1) {
                throw new WebApplicationException("There can be only one captain");
            }
            if (user.getUserPlayers().stream().filter(UserPlayer::isViceCaptain).count() > 1) {
                throw new WebApplicationException("There can be only one vice captain");
            }
            if (user.getUserPlayers().stream().filter(userPlayer -> userPlayer.getPlayer().getPosition().equals(Player.Position.GOALKEEPER)).count() > 2) {
                throw new WebApplicationException("Number of selected goalkeepers must be 2");
            }
            if (user.getUserPlayers().stream().filter(userPlayer -> userPlayer.getPlayer().getPosition().equals(Player.Position.DEFENDER)).count() > 5) {
                throw new WebApplicationException("Number of selected defenders must be 5");
            }
            if (user.getUserPlayers().stream().filter(userPlayer -> userPlayer.getPlayer().getPosition().equals(Player.Position.MIDFILDER)).count() > 5) {
                throw new WebApplicationException("Number of selected midfielders must be 5");
            }
            if (user.getUserPlayers().stream().filter(userPlayer -> userPlayer.getPlayer().getPosition().equals(Player.Position.STRIKER)).count() > 3) {
                throw new WebApplicationException("Number of selected strikers must be 3");
            }
        }

    }

    // Get team for user if userId is null return team for currently logged in user.
    public List<PlayerDto> getTeam(Long userId) {
        if (userId == null) {
            userId = ((CustomAutentication) SecurityContextHolder.getContext().getAuthentication()).getPrincipal().getUserId();
        }
        User user = userDao.findById(userId);
        if (user == null) {
            throw new WebApplicationException("User not found");
        }
        return user.getUserPlayers().stream().map(PlayerAssembler::getPlayerDto).collect(Collectors.toList());
    }

    public List<TopPlayersDto> getTopPlayers() {
        return playerDao.getTopPlayers();
    }

    public List<TopPlayersDto> getTopPlayersPerRound(Integer round) {
        if (round == null) {
            // find latest scored round
            round = matchPlayerStatDao.findLatestScoredRound();
        }
        if (round == null) {
            return null;
        }
        return playerDao.getTopPlayersPerRound(round);
    }
}
