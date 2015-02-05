package com.dextra.webapp.context;

import javax.transaction.UserTransaction;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.ext.ResponseHandler;
import org.apache.cxf.jaxrs.model.OperationResourceInfo;
import org.apache.cxf.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class TransactionResponseHandler implements ResponseHandler {

    private static final int ACTIVE = javax.transaction.Status.STATUS_ACTIVE;
    private final Logger logger = LoggerFactory.getLogger(TransactionResponseHandler.class);

    @Override
    public Response handleResponse(Message m, OperationResourceInfo ori, Response response) {
        UserTransaction transaction = TransactionContainer.get();
        String httpMethod = (String) m.get(Message.HTTP_REQUEST_METHOD);

        try {
            if (!"GET".equals(httpMethod) && transaction.getStatus() == ACTIVE) {
                transaction.commit();
            }
            return response;

        } catch (Exception e) {
            logger.error("Error trying to commit");
            ResponseBuilder responseBuilder = Response.status(Status.INTERNAL_SERVER_ERROR);
            return responseBuilder.entity(e.getMessage()).build();
        }
    }

}
