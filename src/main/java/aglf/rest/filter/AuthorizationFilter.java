package aglf.rest.filter;

import aglf.data.model.User;
import aglf.service.UserService;
import org.glassfish.jersey.server.ContainerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationFilter implements ContainerRequestFilter {

    @Autowired
    private UserService userService;

    @Context
    private HttpServletRequest servletRequest;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

        if (!shouldFilter(((ContainerRequest) containerRequestContext.getRequest()).getRequestUri().getPath())) {
            return;
        }

        // get authentication token
        String authorizationToken = containerRequestContext.getHeaderString("Authorization");

        if (authorizationToken == null || authorizationToken.isEmpty()) {
            throw new WebApplicationException(401);
        }


        User user = userService.findUserByToken(authorizationToken);

        if (user == null) {
            throw new WebApplicationException(403);
        }

        // add userOld id to security context
        SecurityContextUser userSecurityContext = new SecurityContextUser(user.getId());
        SecurityContextHolder.clearContext();
        SecurityContextHolder.getContext().setAuthentication(new CustomAutentication(userSecurityContext));

    }

    private boolean shouldFilter(String url) {
        if (url.contains("/login") || url.contains("/signUp")) {
            return false;
        }
        return true;
    }
}


