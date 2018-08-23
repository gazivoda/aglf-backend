package aglf.rest;

import aglf.service.dto.CreateUserDto;
import aglf.service.dto.UserAndPassDto;
import aglf.service.dto.UserDetailsDto;
import aglf.service.dto.UserTokenDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public interface UserRest {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    UserTokenDto login(UserAndPassDto userAndPassDto);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("signUp")
    UserTokenDto signUp(CreateUserDto createUserDto);

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/getUserDetails")
    UserDetailsDto getUserDetails(@QueryParam("userId") Long userId);

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/getTopUsers")
    List<UserDetailsDto> getTopUsers();

}
