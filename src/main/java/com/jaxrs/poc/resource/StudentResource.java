package com.jaxrs.poc.resource;

import com.jaxrs.poc.model.Student;
import com.jaxrs.poc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.*;

@Path("/students")
public class StudentResource {

    @Autowired
    StudentService service;

    @Autowired
    MarksResource marksResource;

    /*Fetches all students in DB*/
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response getAllStudents() {
        List<Student> studentsList = service.getAllStudents();
        if(CollectionUtils.isEmpty(studentsList))
            return Response.status(NOT_FOUND).build();
        else
            return Response.status(OK).entity(studentsList).build();
    }

    /*Fetches a student by their studentId*/
    @GET
    @Path("/{sid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response getStudent(@PathParam("sid") int sid) {
        Student student = service.getStudentById(sid);
        if(student == null)
            return Response.status(NOT_FOUND).build();
        else
            return Response.status(OK).entity(student).build();
    }

    /*Creates a new student */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response createStudent(@RequestBody Student student) {
        student = service.createStudent(student);
        return Response.status(CREATED).entity(student).build();
    }

    /*Modify/Update an existing student*/
    @PUT
    @Path("/{sid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response updateStudent(@PathParam("sid") int sid, @RequestBody Student student) {
        student.setStudentId(sid);
        student = service.updateStudent(student);
        return Response.status(ACCEPTED).entity(student).build();
    }


    /*Deletes an existing student by their studentId*/
    @DELETE
    @Path("/{sid}")
    public Response deleteStudent(@PathParam("sid") int sid) {
        service.deleteStudentById(sid);
        return Response.status(OK).build();
    }

    @Path("/{sid}/marks")
    public MarksResource getMarksResource() {
        return marksResource;
    }
}
