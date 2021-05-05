/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospitalejb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Erika Moreno
 * @author Anderson Nevao
 * @since 25/04/2021
 * @version 1.0.0
 */
@Entity
@Table(name = "consulta")

@NamedQueries({
    @NamedQuery(name = "Consulta.listarTodos", query = "SELECT c FROM Consulta c"),
    @NamedQuery(name = "Consulta.EliminarOptimo", query = "DELETE FROM Consulta c"),
    @NamedQuery(name = "Consulta.Count", query = "SELECT COUNT(c.id) FROM Consulta c WHERE c.id = :paramId")
})
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "nombre_medico", nullable = false, length = 50)
    private String nombreMedico;

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<DetalleConsulta> detalleConsulta;

    @JsonbTransient
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public List<DetalleConsulta> getDetalleConsulta() {
        return detalleConsulta;
    }

    public void setDetalleConsulta(List<DetalleConsulta> detalleConsulta) {
        this.detalleConsulta = detalleConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}
