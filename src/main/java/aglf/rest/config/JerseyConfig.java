package aglf.rest.config;

import aglf.rest.impl.UserRestImpl;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(UserRestImpl.class);
        register(GenericExceptionMapper.class);
    }
}