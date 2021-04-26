/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospital.exceptionfilter;

import edu.unicundi.hospital.Pojo.ErrorPOJO;
import edu.unicundi.hospitalejb.exception.IntegridadException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Filtro que captura las excepciones que se dispara cuando encuentra un conflicto en la peticion
 * @author Erika Moreno
 * @author Anderson Nevao
 * @since  25/04/2021 
 * @version 1.0.0
 */
@Provider
public class IntegridadExceptionFilter implements ExceptionMapper<IntegridadException> {

    @Override
    public Response toResponse(IntegridadException exception) {
        System.out.println("Exception: " + exception.getClass().getCanonicalName());
        
        String descripcion = "Conflicto con el estado actual del servidor";
        String codigo = "409";
        String codigoNombre = "Conflict";

        ErrorPOJO error = new ErrorPOJO(descripcion, codigo, codigoNombre);
        return Response.status(Response.Status.CONFLICT).entity(error).build();
    }
    
}
