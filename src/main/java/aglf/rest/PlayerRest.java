package aglf.rest;

import aglf.service.PlayerService;
import aglf.service.dto.PlayersListDto;
import aglf.service.dto.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class PlayerRest {

    @Autowired
    private PlayerService playerService;

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/getAll")
    public List<PlayerDto> getAll() {
        return playerService.findAllPlayers();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/setPlayers")
    public void setPlayers(PlayersListDto playersListDto) {
        playerService.setPlayers(playersListDto);
    }

}
