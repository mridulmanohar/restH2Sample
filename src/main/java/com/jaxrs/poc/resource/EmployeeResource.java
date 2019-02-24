package com.jaxrs.poc.resource;

import com.jaxrs.poc.model.Employee;
import com.jaxrs.poc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.*;

@Path("/employees")
public class EmployeeResource {

    @Autowired
    EmployeeService service;

    /*Fetches all employees in DB*/
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response getAllEmployees() {
        List<Employee> employeeList = service.getAllEmployees();
        if(CollectionUtils.isEmpty(employeeList))
            return Response.status(NOT_FOUND).build();
        else
            return Response.status(OK).entity(employeeList).build();
    }

    /*Fetches an employee by it's empId*/
    @GET
    @Path("/{empId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response getEmployee(@PathParam("empId") int empId) {
       Employee emp = service.getEmployeeById(empId);
       if(emp == null)
           return Response.status(NOT_FOUND).build();
       else
           return Response.status(OK).entity(emp).build();
    }

    @GET
    @Path("/query")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response getEmployeesByCriteria(@QueryParam("deptId") int deptId,
                                                @QueryParam("salary") long salary) {
        if(deptId == 0)
            return Response.status(BAD_REQUEST).build();

        List<Employee> empList = service.getEmployeesByCriteria(deptId, salary);
        if(!CollectionUtils.isEmpty(empList))
            return Response.status(OK).entity(empList).build();
        else
            return Response.status(NO_CONTENT).build();

    }

    /*Creates a new Employee */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response createEmployee(@RequestBody Employee emp) {
        emp = service.createEmployee(emp);
        return Response.status(CREATED).entity(emp).build();
    }

    /*Modify/Update an existing employee*/
    @PUT
    @Path("/{empId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response updateEmployee(@PathParam("empId") int empId, @RequestBody Employee emp) {
        emp.setEmpId(empId);
        emp = service.updateEmployee(emp);
        return Response.status(ACCEPTED).entity(emp).build();
    }


    /*Deletes an existing employee by its empId*/
    @DELETE
    @Path("/{empId}")
    public Response deleteEmployee(@PathParam("empId") int empId) {
        service.deleteEmployeeById(empId);
        return Response.status(OK).build();
    }

    @GET
    @Path("/hello")
    public String helloWorld() {
        return "HelloWorld";
    }
}
