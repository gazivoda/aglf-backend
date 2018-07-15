package aglf.service;

import aglf.data.dao.PlayerDao;
import aglf.service.assembler.PlayerAssembler;
import aglf.service.dto.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayerService {

    @Autowired
    private PlayerDao playerDao;

    public List<PlayerDto> findAllPlayers() {
        return playerDao.findAll().stream().map(PlayerAssembler::getPlayerDto).collect(Collectors.toList());
    }

}
