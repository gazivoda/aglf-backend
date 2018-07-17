package aglf.service.dto;

import java.util.HashSet;
import java.util.Set;

public class PlayersListDto {

    private Set<Long> playerIds = new HashSet<>();

    public Set<Long> getPlayerIds() {
        return playerIds;
    }

    public void setPlayerIds(Set<Long> playerIds) {
        this.playerIds = playerIds;
    }
}
