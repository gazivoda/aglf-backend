package aglf.rest;

import aglf.data.model.Player;
import aglf.service.PlayerService;
import aglf.service.UserService;
import aglf.service.dto.CreateUserDto;
import aglf.service.dto.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    public List<PlayerDto> getAll(){
        return playerService.findAllPlayers();
    }

}
