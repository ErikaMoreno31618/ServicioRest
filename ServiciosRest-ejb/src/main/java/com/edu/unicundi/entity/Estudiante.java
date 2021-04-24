/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unicundi.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase donde se enlazan las columnas con la tabla de base de datos
 *
 * @author Erika Moreno
 * @version 1.0.0
 */
@Entity
@Table(name = "estudiante")
public class Estudiante implements Serializable  {
    @Id
    private Integer id;
    
    @Column(name = "cedula", nullable = false, length = 20)
    private String cedula;
    
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    
    @Column(name = "apellido", nullable = false, length = 255)
    private String apellido;
    
    @Column(name = "edad", nullable = false)
    private Integer edad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

}
