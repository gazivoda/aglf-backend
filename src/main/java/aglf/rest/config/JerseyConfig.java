package aglf.rest.config;

import aglf.rest.MigrationRest;
import aglf.rest.PlayerRest;
import aglf.rest.filter.AuthorizationFilter;
import aglf.rest.filter.CorsFilter;
import aglf.rest.impl.UserRestImpl;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(GenericExceptionMapper.class);
        register(AuthorizationFilter.class);
        register(UserRestImpl.class);
        register(PlayerRest.class);
        register(MigrationRest.class);
        register(CorsFilter.class);
    }
}