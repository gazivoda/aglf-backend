package aglf.service;

import aglf.data.dao.PlayerDao;
import aglf.data.dao.UserDao;
import aglf.data.model.User;
import aglf.rest.filter.CustomAutentication;
import aglf.service.assembler.PlayerAssembler;
import aglf.service.dto.PlayerDto;
import aglf.service.dto.PlayersListDto;
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

    public List<PlayerDto> findAllPlayers() {
        return playerDao.findAll().stream().map(PlayerAssembler::getPlayerDto).collect(Collectors.toList());
    }

    public void setPlayers(PlayersListDto playersListDto) {
        User user = userDao.findById(((CustomAutentication) SecurityContextHolder.getContext().getAuthentication()).getPrincipal().getUserId());
        if (user == null) {
            throw new WebApplicationException("User not found");
        }
        // TODO validate user list

        user.getPlayers().clear();
        for (Long playerId : playersListDto.getPlayerIds()) {
            user.getPlayers().add(playerDao.loadById(playerId));
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
        return user.getPlayers().stream().map(PlayerAssembler::getPlayerDto).collect(Collectors.toList());
    }
}
