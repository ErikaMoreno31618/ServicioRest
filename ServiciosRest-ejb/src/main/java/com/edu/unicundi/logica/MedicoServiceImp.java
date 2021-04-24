/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unicundi.logica;

import com.edu.unicundi.entity.Medico;
import com.edu.unicundi.exception.BadRequestException;
import com.edu.unicundi.exception.IntegridadException;
import com.edu.unicundi.exception.NoContentException;
import com.edu.unicundi.exception.NotFoundObjectException;
import com.edu.unicundi.interfaces.IMedicoService;
import com.edu.unicundi.repository.IConsultaRepo;
import com.edu.unicundi.repository.IMedicoRepo;
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
public class MedicoServiceImp implements IMedicoService {

    @EJB
    private IMedicoRepo repo;

    @Override
    public List<Medico> listar() throws NoContentException, NotAllowedException {
        List<Medico> medico = new ArrayList();
        medico = repo.listar();
        if (medico.size() > 0) {
            return medico;
        } else {
            throw new NoContentException("La lista se encuentra vacia");
        }
    }

    @Override
    public Medico BuscarPorId(Integer id) throws NoContentException, NotAllowedException, NotFoundObjectException {
        Medico medico = repo.buscarMedico(id);
        return medico;
    }

    @Override
    public void guardar(Medico medico) throws IntegridadException, BadRequestException, NotAllowedException {
        medico.getDireccion().setMedico(medico);
        repo.guardar(medico);
    }

    @Override
    public void eliminar(Integer idMedico) throws NotFoundObjectException, NotAllowedException {
        try {
            Medico medico = repo.BuscarPorId(idMedico);
            if (medico != null) {
                repo.eliminar(medico);
            } else {
                throw new NotFoundObjectException("medico no encontrado");
            }
        } catch (NoContentException ex) {
            Logger.getLogger(ConsultaServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editar(Medico medico) throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException {
        if(medico.getId() == null){
     
        }
        Medico ValidarMedico = repo.buscarMedico(medico.getId());
        ValidarMedico.setNombre(medico.getNombre());
        ValidarMedico.setApellido(medico.getApellido());
        ValidarMedico.setCorreo(medico.getCorreo());
        ValidarMedico.setFechaNacimiento(medico.getFechaNacimiento());
        if (medico.getDireccion() != null) {
            ValidarMedico.getDireccion().setBarrio(medico.getDireccion().getBarrio());
            ValidarMedico.getDireccion().setCodigoPostal(medico.getDireccion().getCodigoPostal());
        }

        repo.editar(ValidarMedico);

    }

    @Override
    public Medico buscarMedico(int id) {
        Medico medico = repo.buscarMedico(id);
        return medico;
    
    }

}
