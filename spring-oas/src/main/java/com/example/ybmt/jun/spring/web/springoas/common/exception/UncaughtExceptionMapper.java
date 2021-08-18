package com.example.ybmt.jun.spring.web.springoas.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.example.ybmt.jun.spring.web.springoas.common.model.ErrorMessage;
import com.example.ybmt.jun.spring.web.springoas.message.SpringOASLogger;

import org.jboss.logging.Logger;

@Provider
public class UncaughtExceptionMapper implements ExceptionMapper<Throwable> {

	private static final SpringOASLogger log = Logger.getMessageLogger(SpringOASLogger.class, UncaughtExceptionMapper.class.getName());

    @Override
    public Response toResponse(Throwable exception) {
        log.internalServerError(exception);
        return Response.status(Status.INTERNAL_SERVER_ERROR)
            .entity(new ErrorMessage("id","INTERNAL_SERVER_ERROR"))
            .build();
    }
}
