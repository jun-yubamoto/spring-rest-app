package com.example.ybmt.jun.spring.web.springoas.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("myresource")
public class HelloWorld {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return String.format("Hello !");
	}

}