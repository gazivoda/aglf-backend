package aglf.rest;

import aglf.migration.MigrationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/migration")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class MigrationRest {

    @Autowired
    private MigrationUtil migrationUtil;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/importSchedule")
    public void importMatchSchedule(@QueryParam("pass") String pass) {
        if (!pass.equals("aglf0202IP")) {
            throw new WebApplicationException("Odjebi");
        }
        migrationUtil.importMatchSchedule();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/importTeamAndPlayers")
    public void importTeamAndPlayers(@QueryParam("pass") String pass) {
        if (!pass.equals("aglf0202IP")) {
            throw new WebApplicationException("Odjebi");
        }
        migrationUtil.importTeams();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/scoreMatches")
    public void scoreMatches(@QueryParam("pass") String pass) {
        if (!pass.equals("aglf0202IP")) {
            throw new WebApplicationException("Odjebi");
        }
        migrationUtil.startMatchScoring();
    }

}
