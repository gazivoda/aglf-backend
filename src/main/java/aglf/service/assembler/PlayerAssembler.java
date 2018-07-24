package aglf.service.assembler;

import aglf.data.model.Player;
import aglf.data.model.UserPlayer;
import aglf.service.dto.PlayerDto;

public class PlayerAssembler {

    public static PlayerDto getPlayerDto(Player player) {
        PlayerDto dto = new PlayerDto();
        dto.setId(player.getId());
        dto.setFirstName(player.getFirstName());
        dto.setLastName(player.getLastName());
        dto.setPosition(player.getPosition());
        dto.setTeamName(player.getTeam().getName());
        dto.setTeamId(player.getTeam().getId());
        dto.setPrice(player.getPrice());
        return dto;
    }

    public static PlayerDto getPlayerDto(UserPlayer userPlayer) {
        PlayerDto dto = new PlayerDto();
        dto.setId(userPlayer.getPlayer().getId());
        dto.setFirstName(userPlayer.getPlayer().getFirstName());
        dto.setLastName(userPlayer.getPlayer().getLastName());
        dto.setPosition(userPlayer.getPlayer().getPosition());
        dto.setTeamName(userPlayer.getPlayer().getTeam().getName());
        dto.setTeamId(userPlayer.getPlayer().getTeam().getId());
        dto.setPrice(userPlayer.getPlayer().getPrice());
        dto.setActive(userPlayer.isActive());
        dto.setCaptain(userPlayer.isCaptain());
        dto.setViceCaptain(userPlayer.isViceCaptain());
        return dto;
    }

}
