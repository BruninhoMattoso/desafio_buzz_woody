package com.dextra.webapp.context;

import javax.transaction.UserTransaction;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class ThrowableMapper implements ExceptionMapper<Throwable> {

    private final Logger logger = LoggerFactory.getLogger(ThrowableMapper.class);

    @Override
    public Response toResponse(Throwable exception) {
        UserTransaction transaction = TransactionContainer.get();

        try {
            transaction.rollback();
        } catch (Exception e) {
            logger.error("Error trying to rollback", e);
        }

        logger.error("Uncaught exception", exception);
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(exception.getMessage()).build();
    }

}
