package edu.unicundi.hospitalejb.entity;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Erika Moreno
 */
@Entity
@Table(name = "direccion")
public class Direccion implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @JsonbTransient
    @OneToOne
    @MapsId
    private Medico medico;

    @Column(name = "direccionDetallada", nullable = false, length = 25)
    private String direccionDetallada;

    @Column(name = "barrio", nullable = false, length = 25)
    private String barrio;

    @Column(name = "codigoPostal", nullable = false, length = 6)
    private String codigoPostal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getDireccionDetallada() {
        return direccionDetallada;
    }

    public void setDireccionDetallada(String direccionDetallada) {
        this.direccionDetallada = direccionDetallada;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

}
