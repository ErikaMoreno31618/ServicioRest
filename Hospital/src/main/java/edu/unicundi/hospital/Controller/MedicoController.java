/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospital.Controller;

import edu.unicundi.hospitalejb.entity.Medico;
import edu.unicundi.hospitalejb.exception.BadRequestException;
import edu.unicundi.hospitalejb.exception.IntegridadException;
import edu.unicundi.hospitalejb.exception.NoContentException;
import edu.unicundi.hospitalejb.exception.NotFoundObjectException;
import edu.unicundi.hospitalejb.interfaces.IMedicoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Erika Moreno
 * @author Anderson Nevao
 * @since  25/04/2021 
 */
@RequestScoped
@Path("/medicos")
public class MedicoController {

    @EJB
    private IMedicoService service;

    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() throws NoContentException {
        List<Medico> medico = service.listar();
        return Response.status(Response.Status.OK).entity(medico).build();
    }

    @Path("guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@Valid Medico medico) throws IntegridadException, BadRequestException {
        service.guardar(medico);
        return Response.status(Response.Status.CREATED).entity("Se ha creado satisfactoriamente.").build();
    }

    @Path("eliminar/{idMedico}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("idMedico") int idMedico) throws IntegridadException, BadRequestException, NotFoundObjectException {
        service.eliminar(idMedico);
        return Response.status(Response.Status.NO_CONTENT).entity("Se ha eliminado satisfactoriamente.").build();
    }

    @Path("buscarPorId/{idMedico}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("idMedico") int idMedico) throws IntegridadException, BadRequestException, NotFoundObjectException, NoContentException {
        Medico medico = service.buscarMedico(idMedico);
        return Response.status(Response.Status.OK).entity(medico).build();
    }

    @Path("editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@Valid Medico medico) throws IntegridadException, NotFoundObjectException, BadRequestException {
        service.editar(medico);
        return Response.status(Response.Status.OK).entity("Se ha editado satisfactoriamente.").build();
    }

}
