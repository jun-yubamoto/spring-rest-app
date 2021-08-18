package com.example.ybmt.jun.spring.web.springoas.common.modules;

import java.util.Collection;

import javax.ws.rs.container.AsyncResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.ybmt.jun.spring.web.springoas.common.model.ErrorMessage;

public class CommonAsyncResponse<E extends Object> {

    private final AsyncResponse asyncResponse;

    private boolean implementsIndividualErrorResponse = true;

    public CommonAsyncResponse(AsyncResponse asyncResponse){
        this.asyncResponse = asyncResponse;
    }

    public void response(Status normalResponseStatus, E entity) {
        if (entity == null ){
            asyncResponse.resume( 
						Response.status(Status.NOT_FOUND)
						.entity(new ErrorMessage("id","message"))
						.build());
        } else {
            if (entity instanceof Collection) {
                Collection<?> c = (Collection<?>) entity;
                if (c.isEmpty()) {
                    asyncResponse.resume( 
						Response.status(Status.NOT_FOUND)
						.entity(new ErrorMessage("id","message"))
						.build());
                }
            } else {
                asyncResponse.resume( 
                    Response.status(normalResponseStatus)
                        .entity(entity)
                        .build());
            }
        }
    }
    
    public void errorResponse(String responseMessage, Exception e) {
        this.individualErrorResponse(responseMessage, e);
        if (!implementsIndividualErrorResponse) {
            if (e instanceof IllegalArgumentException ) {
                asyncResponse.resume( 
                    Response.status(Status.BAD_REQUEST)
                    .entity(new ErrorMessage("id","message"))
                    .build());
            } else {
                asyncResponse.resume( 
                    Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorMessage("id","message"))
                    .build());
            }
        }
    }

    protected void individualErrorResponse(String responseMessage, Exception e) {
        implementsIndividualErrorResponse = false;
    }
}
