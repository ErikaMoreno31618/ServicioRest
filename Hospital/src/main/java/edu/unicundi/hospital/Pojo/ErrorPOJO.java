/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospital.Pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Envoltorio de error para respuestas
 *
 * @author Erika Moreno
 * @version 1.0.0
 */
public class ErrorPOJO implements Serializable {

    /**
     * Descripcion del error
     */
    private String error;

    /**
     * Codigo de respuesta http
     */
    private String codigo;

    /**
     * Nombre del codigo de respuesta
     */
    private String codigoNombre;

    /**
     * Fecha en que ocurre el error
     */
    private String fecha;

    /**
     * Constructor de clase
     *
     * @param error
     * @param codigo
     * @param codigoNombre
     */
    public ErrorPOJO(String error, String codigo, String codigoNombre) {
        this.error = error;
        this.codigo = codigo;
        this.codigoNombre = codigoNombre;
        this.fecha = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(new Date());
    }

    public ErrorPOJO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the codigoNombre
     */
    public String getCodigoNombre() {
        return codigoNombre;
    }

    /**
     * @param codigoNombre the codigoNombre to set
     */
    public void setCodigoNombre(String codigoNombre) {
        this.codigoNombre = codigoNombre;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
