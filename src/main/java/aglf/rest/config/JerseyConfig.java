package aglf.rest.config;

import aglf.rest.PlayerRest;
import aglf.rest.impl.UserRestImpl;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(GenericExceptionMapper.class);
        register(UserRestImpl.class);
        register(PlayerRest.class);
    }
}