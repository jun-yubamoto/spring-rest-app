package com.example.ybmt.jun.spring.web.springoas.config;

import javax.ws.rs.ApplicationPath;

import com.example.ybmt.jun.spring.web.springoas.common.exception.NotFoundExceptionMapper;
import com.example.ybmt.jun.spring.web.springoas.common.exception.UncaughtExceptionMapper;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

@Configuration
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(NotFoundExceptionMapper.class);
        register(UncaughtExceptionMapper.class);
        register(OpenApiResource.class);
        packages("com.example.ybmt.jun.spring.web.springoas.resource");
    }
    
}
