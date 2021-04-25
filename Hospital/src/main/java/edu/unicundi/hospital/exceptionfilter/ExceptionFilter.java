/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospital.exceptionfilter;

import edu.unicundi.hospital.Pojo.ErrorPOJO;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Filtro que captura las excepciones que se disparan y no esten filtradas
 *
 * @author Erika Moreno
 * @version 1.0.0
 */
@Provider
public class ExceptionFilter implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {
        System.out.println("Exception: " + ex.getClass().getCanonicalName());
        
        String descripcion = "Ha ocurrido un error en el servidor";
        String codigo = "500";
        String codigoNombre = "Internal Server Error";

        ErrorPOJO error = new ErrorPOJO(descripcion, codigo, codigoNombre);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }

}
