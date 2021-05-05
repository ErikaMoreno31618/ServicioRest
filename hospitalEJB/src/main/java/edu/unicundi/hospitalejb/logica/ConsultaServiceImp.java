/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospitalejb.logica;

import edu.unicundi.hospitalejb.entity.Consulta;
import edu.unicundi.hospitalejb.entity.DetalleConsulta;
import edu.unicundi.hospitalejb.exception.BadRequestException;
import edu.unicundi.hospitalejb.exception.IntegridadException;
import edu.unicundi.hospitalejb.exception.NoContentException;
import edu.unicundi.hospitalejb.exception.NotFoundObjectException;
import edu.unicundi.hospitalejb.interfaces.IConsultaService;
import edu.unicundi.hospitalejb.repositoryimp.ConsultaRepoImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.NotAllowedException;

/**
 * @author Erika Moreno
 * @author Anderson Nevao
 * @since  25/04/2021 
 * @version 1.0.0
 */
@Stateless
public class ConsultaServiceImp implements IConsultaService {

    @EJB
    private ConsultaRepoImp repo;

    @Override
    public List<Consulta> listar() throws NoContentException, NotAllowedException {
        List<Consulta> consulta = new ArrayList();
        consulta = repo.listar();
        if (consulta.size() > 0) {
            return consulta;
        } else {
            throw new NoContentException("La lista se encuentra vacia");
        }
    }

    @Override
    public Consulta BuscarPorId(Integer id) throws NoContentException, NotAllowedException, NotFoundObjectException {
        Consulta consulta = repo.buscarporId(id);
        return consulta;

    }

    @Override
    public void guardar(Consulta consulta) throws IntegridadException, BadRequestException, NotAllowedException {
        if (consulta.getDetalleConsulta() != null) {
            for (DetalleConsulta dc : consulta.getDetalleConsulta()) {
                dc.setConsulta(consulta);
            }
        }
        repo.guardar(consulta);
    }

    @Override
    public void eliminar(Integer idConsulta) throws NotFoundObjectException, NotAllowedException {
            int numero = repo.contarSiExiste(idConsulta);
            if (numero > 0) {
                repo.eliminarOptimo(idConsulta);
            } else {
                throw new NotFoundObjectException("Consulta no encontrada");
            }
    }

    @Override
    public void editar(Consulta consulta) throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException {
        Consulta ValidarConsulta = repo.buscarporId(consulta.getId());

        ValidarConsulta.setNombreMedico(consulta.getNombreMedico());
        ValidarConsulta.setFecha(consulta.getFecha());

        if (consulta.getDetalleConsulta() != null) {
            for (DetalleConsulta item : consulta.getDetalleConsulta()) {
                for (DetalleConsulta item2 : ValidarConsulta.getDetalleConsulta()) {
                    if (Objects.equals(item.getId(), item2.getId())) {
                        item2.setDiagnostico(item.getDiagnostico());
                        item2.setTratamiento(item.getTratamiento());
                    }
                }
            }
        }

        repo.editar(ValidarConsulta);
    }
}
