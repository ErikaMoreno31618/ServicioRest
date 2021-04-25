/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospital.exceptionfilter;

import edu.unicundi.hospital.Pojo.ErrorPOJO;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Filtro que captura la excepcion que se dispara cuando se envia el motodo incorecto en la peticion
 *
 * @author Erika Moreno
 * @version 1.0.0
 */
@Provider
public class MethodNotAllowedExceptionFilter implements ExceptionMapper<NotAllowedException> {

    @Override
    public Response toResponse(NotAllowedException ex) {
        String descripcion = "El método no corresponde, debe ser " + ex.getResponse().getAllowedMethods().toArray()[0];
        String codigo = Integer.toString(ex.getResponse().getStatus());
        String codigoNombre = ex.getResponse().getStatusInfo().getReasonPhrase();

        ErrorPOJO error = new ErrorPOJO(descripcion, codigo, codigoNombre);
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(error).build();
    }
}
