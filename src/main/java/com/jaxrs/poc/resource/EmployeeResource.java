package com.jaxrs.poc.resource;

import com.jaxrs.poc.model.Employee;
import com.jaxrs.poc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/emp")
public class EmployeeResource {

    @Autowired
    EmployeeService service;

    /*Fetches an employee by it's empId*/
    @GET
    @Path("/{empId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("empId") int empId) {
       Employee emp = service.getEmployeeById(empId);
       return emp;
    }

    /*Creates a new Employee */
    @POST
    @Path("/{emp}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createEmployee(@RequestBody Employee emp) {
        emp = service.createEmployee(emp);
        return Response.status(200).entity(emp).build();
    }

    /*Modify/Update an existing employee*/
    @PUT
    @Path("/{emp}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateEmployee(@RequestBody Employee emp) {
        emp = service.updateEmployee(emp);
        return Response.status(200).entity(emp).build();
    }


    /*Deletes an existing employee by its empId*/
    @DELETE
    @Path("/{empId}")
    public Response deleteEmployee(@PathParam("empId") int empId) {
        service.deleteEmployeeById(empId);
        return Response.status(200).build();
    }

    @GET
    @Path("/hello")
    public String helloWorld() {
        return "HelloWorld";
    }
}
