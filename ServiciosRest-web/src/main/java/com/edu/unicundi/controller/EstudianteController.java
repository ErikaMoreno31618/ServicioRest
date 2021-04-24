/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unicundi.controller;

import com.edu.unicundi.entity.Estudiante;
import com.edu.unicundi.exception.BadRequestException;
import com.edu.unicundi.exception.IntegridadException;
import com.edu.unicundi.exception.NoContentException;
import com.edu.unicundi.exception.NotFoundObjectException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import com.edu.unicundi.interfaces.ILogicaEstudiante;
import com.edu.unicundi.repository.IEstudianteRepo;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *Controlamos todas las respuestas para el usuario
 *
 * @author Erika Moreno
 * @version 1.0.0
 */
@Stateless
@Path("/estudiantes")
public class EstudianteController {

    @EJB
    public ILogicaEstudiante service;

    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() throws NoContentException {
        List<Estudiante> estudiantes = service.listar();
        return Response.status(Response.Status.OK).entity(estudiantes).build();
    }
    @Path("guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar (@Valid Estudiante estudiante) throws IntegridadException, BadRequestException {
        service.guardar(estudiante);
        return Response.status(Response.Status.CREATED).entity("Se ha creado satisfactoriamente.").build();
    }
     @Path("eliminar/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") Integer idEstudiante) throws NotFoundObjectException {
        service.eliminar(idEstudiante);
      return Response.status(Response.Status.OK).entity("Estudiante eliminado").build();
    }
    @Path("editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@Valid Estudiante estudiante) throws IntegridadException, NotFoundObjectException, BadRequestException{
        service.editar(estudiante);
        return Response.status(Response.Status.OK).entity("Se ha editado satisfactoriamente.").build();
    }
   
}
