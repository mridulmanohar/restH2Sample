package com.jaxrs.poc.resource;

import com.jaxrs.poc.model.Marks;
import com.jaxrs.poc.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.*;

public class MarksResource {

    @Autowired
    private MarksService service;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response getStudentMarks(@PathParam("sid") int sid) {
        List<Marks> marksList = service.getStudentMarks(sid);
        if(CollectionUtils.isEmpty(marksList))
            return Response.status(NOT_FOUND).build();
        else
            return Response.status(OK).entity(marksList).build();
    }

    @GET
    @Path("/{seqId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response getStudentMarksById(@PathParam("seqId") int seqId) {
        Marks marks = service.getMarksById(seqId);
        if(marks == null)
            return Response.status(NOT_FOUND).build();
        else
            return Response.status(OK).entity(marks).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response addStudentMarks(@PathParam("sid") int sid, @RequestBody Marks marks) {
        marks = service.addMarks(sid, marks);
        return Response.status(CREATED).entity(marks).build();
    }

    @PUT
    @Path("/{seqId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response updateMarks(@PathParam("sid") int sid, @PathParam("seqId") int seqId, @RequestBody Marks marks) {
        marks = service.updateMarks(sid, seqId, marks);
        return Response.status(ACCEPTED).entity(marks).build();
    }

    @DELETE
    @Path("/{seqId}")
    public Response deleteMarks(@PathParam("seqId") int seqId) {
        service.deleteMarksById(seqId);
        return Response.status(OK).build();
    }
}
