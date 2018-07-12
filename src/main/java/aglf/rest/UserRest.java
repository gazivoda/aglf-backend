package aglf.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public interface UserRest {

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/login")
    String login(@QueryParam("username") String username, @QueryParam("password") String password);

}
