package aglf.service.assembler;

import aglf.data.model.Player;
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

}
