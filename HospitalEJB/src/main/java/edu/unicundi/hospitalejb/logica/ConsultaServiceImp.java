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
import edu.unicundi.hospitalejb.repository.IConsultaRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.NotAllowedException;

/**
 *
 * @author Erika Moreno
 */
@Stateless
public class ConsultaServiceImp implements IConsultaService {

    @EJB
    private IConsultaRepo repo;

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
        Consulta consulta = repo.buscarConsulta(id);
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

        try {
            Consulta consulta = repo.BuscarPorId(idConsulta);
            if (consulta != null) {
                repo.eliminar(consulta);
            } else {
                throw new NotFoundObjectException("Consulta no encontrada");
            }
        } catch (NoContentException ex) {
            Logger.getLogger(ConsultaServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Consulta consulta) throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException {
//        Consulta ValidarConsulta = repo.buscarConsulta(consulta.getId());
//        if (ValidarConsulta == null) {
//            throw new IntegridadException("La consulta ya existe");
//        } else {
//            repo.editar(consulta);
//        }
//        
//        
//        
//        if(consulta.getId() == null){
//     
//        }
        Consulta ValidarConsulta = repo.buscarConsulta(consulta.getId());
        
        ValidarConsulta.setNombreMedico(consulta.getNombreMedico());
        ValidarConsulta.setFecha(consulta.getFecha());
        
        if (consulta.getDetalleConsulta() != null) {
//            ValidarMedico.getDireccion().setBarrio(medico.getDireccion().getBarrio());
//            ValidarMedico.getDireccion().setCodigoPostal(medico.getDireccion().getCodigoPostal());
           
        }

        repo.editar(ValidarConsulta);

    }
}