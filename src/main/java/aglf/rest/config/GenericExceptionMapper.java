package aglf.rest.config;

import org.apache.log4j.Logger;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    private static final Logger logger = Logger.getLogger(GenericExceptionMapper.class);

    @Override
    public Response toResponse(Throwable ex) {

        ErrorMessageDto errorMessage = new ErrorMessageDto();
        setHttpStatus(ex, errorMessage);
        errorMessage.setCode(500);
        errorMessage.setMessage(ex.getMessage());
        return Response.status(errorMessage.getStatus()).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
    }

    private void setHttpStatus(Throwable ex, ErrorMessageDto errorMessage) {
        if (ex instanceof WebApplicationException) {
            errorMessage.setStatus(((WebApplicationException) ex).getResponse().getStatus());
        } else {
            logger.error("Uncaught error occurred", ex);
            errorMessage.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()); //defaults to internal server error 500
            errorMessage.setMessage("Desila se neocekivana greska");
        }
    }
}
