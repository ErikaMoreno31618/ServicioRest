/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospital.exceptionfilter;

import edu.unicundi.hospital.Pojo.ErrorPOJO;
import edu.unicundi.hospitalejb.exception.NotFoundObjectException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Filtro que captura las excepciones que se dispara cuando la pag no existe
 * @author Erika Moreno
 * @author Anderson Nevao
 * @since  25/04/2021 
 * @version 1.0.0
 */
@Provider
public class NotFoundObjectExceptionFilter implements ExceptionMapper<NotFoundObjectException>{
     @Override
    public Response toResponse(NotFoundObjectException ex) {
        ErrorPOJO error = new ErrorPOJO(ex.getMessage(), "404", "Not Found");
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
