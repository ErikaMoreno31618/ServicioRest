/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospitalejb.dto;

import edu.unicundi.hospitalejb.entity.DetalleConsulta;
import edu.unicundi.hospitalejb.entity.Medico;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Erika Moreno
 */
public class ConsultaDTO implements Serializable {

    private Integer id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    private List<DetalleConsultaDTO> detalleConsulta;

    private MedicoDTO medico;

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

    public List<DetalleConsultaDTO> getDetalleConsulta() {
        return detalleConsulta;
    }

    public void setDetalleConsulta(List<DetalleConsultaDTO> detalleConsulta) {
        this.detalleConsulta = detalleConsulta;
    }

    public MedicoDTO getMedico() {
        return medico;
    }

    public void setMedico(MedicoDTO medico) {
        this.medico = medico;
    }

}
