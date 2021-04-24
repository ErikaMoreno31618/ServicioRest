/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unicundi.exception.filter;

import co.edu.unicundi.POJO.ErrorPOJO;
import com.edu.unicundi.exception.NoContentException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


/**
 * Filtro que captura las excepciones que se disparan cuando la lista se encuentra vacia
 *
 * @author Erika Moreno
 * @version 1.0.0
 */
@Provider
public class NoContentExceptionFilter implements  ExceptionMapper<NoContentException>{

    @Override
    public Response toResponse(NoContentException exception) {
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
}
