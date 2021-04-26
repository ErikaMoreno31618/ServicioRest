/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospitalejb.entity;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Erika Moreno
 * @author Anderson Nevao
 * @since  25/04/2021 
 * @version 1.0.0
 */
@Entity
@Table(name = "detalleconsulta")
public class DetalleConsulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "diagnostico", nullable = true, length = 20)
    private String diagnostico;

    @Column(name = "tratamiento", nullable = true, length = 20)
    private String tratamiento;

    @JsonbTransient
    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false)
    private Consulta consulta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

  
    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

}
