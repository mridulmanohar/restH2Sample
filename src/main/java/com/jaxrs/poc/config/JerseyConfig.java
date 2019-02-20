package com.jaxrs.poc.config;

import com.jaxrs.poc.resource.EmployeeResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

   public JerseyConfig(){
        register(EmployeeResource.class);
    }
}
