/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unicundi.exception.filter;

import co.edu.unicundi.POJO.ErrorPOJO;
import com.edu.unicundi.exception.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Filtro que captura las excepciones cuando la sintaxis es invalida
 *
 * @author Erika Moreno
 * @version 1.0.0
 */
public class BadRequestExceptionFilter implements ExceptionMapper<BadRequestException>{

    @Override
    public Response toResponse(BadRequestException exception) {
        System.out.println("Exception: " + exception.getClass().getCanonicalName());
        
        String descripcion = "Sintaxis Invalida";
        String codigo = "400";
        String codigoNombre = "Bad Request";

        ErrorPOJO error = new ErrorPOJO(descripcion, codigo, codigoNombre);
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
    
}