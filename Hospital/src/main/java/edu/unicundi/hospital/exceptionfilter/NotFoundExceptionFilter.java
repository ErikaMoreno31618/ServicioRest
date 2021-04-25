/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospital.exceptionfilter;

import edu.unicundi.hospital.Pojo.ErrorPOJO;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Filtro que captura la excepcion que se dispara cuando el recurso pedido no se ha encontrado
 *
 * @author  Erika Moreno
 * @version 1.0.0
 */
@Provider
public class NotFoundExceptionFilter implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException ex) {
        String descripcion = "El recurso solicitado no ha sido encontrado";
        String codigo = Integer.toString(ex.getResponse().getStatus());
        String codigoNombre = ex.getResponse().getStatusInfo().getReasonPhrase();
        ErrorPOJO error = new ErrorPOJO(descripcion, codigo, codigoNombre);
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
