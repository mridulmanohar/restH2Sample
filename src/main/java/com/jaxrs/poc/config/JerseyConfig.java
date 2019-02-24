package com.jaxrs.poc.config;

import com.jaxrs.poc.resource.EmployeeResource;
import com.jaxrs.poc.resource.MarksResource;
import com.jaxrs.poc.resource.StudentResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

   public JerseyConfig(){
       register(EmployeeResource.class);
       register(StudentResource.class);
       register(MarksResource.class);
    }
}
