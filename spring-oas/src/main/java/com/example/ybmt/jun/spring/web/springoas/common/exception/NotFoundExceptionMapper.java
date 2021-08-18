package com.example.ybmt.jun.spring.web.springoas.common.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.example.ybmt.jun.spring.web.springoas.common.model.ErrorMessage;
import com.example.ybmt.jun.spring.web.springoas.message.SpringOASLogger;

import org.jboss.logging.Logger;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException>  {
    
	private static final SpringOASLogger log = Logger.getMessageLogger(SpringOASLogger.class, NotFoundExceptionMapper.class.getName());

    @Override
    public Response toResponse(NotFoundException exception) {
        log.notFound(exception);
        return Response.status(Status.NOT_FOUND)
            .entity(new ErrorMessage("id",exception.getMessage()))
            .build();
    }
    
}
