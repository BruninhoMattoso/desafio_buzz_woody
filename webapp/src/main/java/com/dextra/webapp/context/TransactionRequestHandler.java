package com.dextra.webapp.context;

import javax.transaction.UserTransaction;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.ext.RequestHandler;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class TransactionRequestHandler implements RequestHandler {

    private final Logger logger = LoggerFactory.getLogger(TransactionRequestHandler.class);

    @Override
    public Response handleRequest(Message m, ClassResourceInfo resourceClass) {
        UserTransaction transaction = TransactionContainer.get();
        String httpMethod = (String) m.get(Message.HTTP_REQUEST_METHOD);
        try {
            if (!"GET".equals(httpMethod)) {
                transaction.begin();
            }
            return null;

        } catch (Exception e) {
            logger.error("Error on transaction starting", e);
            ResponseBuilder responseBuilder = Response.status(Status.INTERNAL_SERVER_ERROR);
            return responseBuilder.entity(e.getMessage()).build();
        }
    }
}
