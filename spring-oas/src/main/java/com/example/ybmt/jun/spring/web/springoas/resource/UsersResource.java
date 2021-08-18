package com.example.ybmt.jun.spring.web.springoas.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import com.example.ybmt.jun.orm.mbg.model.sample.Users;
import com.example.ybmt.jun.spring.web.springoas.common.modules.CommonAsyncResponse;
import com.example.ybmt.jun.spring.web.springoas.message.SpringOASLogger;
import com.example.ybmt.jun.spring.web.springoas.service.UsersService;

import org.jboss.logging.Logger;

@Path("users")
public class UsersResource {

	private static final SpringOASLogger log = Logger.getMessageLogger(SpringOASLogger.class, UsersResource.class.getName());

	private final UsersService usersService;

	@Inject
	public UsersResource(UsersService usersService){
		this.usersService = usersService;
	}

    @GET
	@Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public void get(@Suspended AsyncResponse asyncResponse, @PathParam("id") String id) {
		CommonAsyncResponse<Users> res = new CommonAsyncResponse<Users>(asyncResponse);
		try {
			Users users = usersService.findById(id);
			res.response(Status.OK, users);
		} catch (Exception e) {
			res.errorResponse("id: responseMessage", e);
		}
	}
}