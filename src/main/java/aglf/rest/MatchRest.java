package aglf.rest;

import aglf.service.MatchService;
import aglf.service.dto.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/match")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class MatchRest {

    @Autowired
    private MatchService matchService;

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/getAll")
    public List<MatchDto> getAll(){
        return matchService.getAll();
    }


}
