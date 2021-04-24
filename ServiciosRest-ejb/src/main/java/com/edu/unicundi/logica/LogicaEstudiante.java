/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unicundi.logica;

import com.edu.unicundi.entity.Estudiante;
import com.edu.unicundi.exception.BadRequestException;
import com.edu.unicundi.exception.IntegridadException;
import com.edu.unicundi.exception.NoContentException;
import com.edu.unicundi.exception.NotFoundObjectException;
import com.edu.unicundi.interfaces.ILogicaEstudiante;
import com.edu.unicundi.repository.IEstudianteRepo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;

/**
 * Clase de implementacion de logica
 *
 * @author Erika Moreno
 * @version 1.0.0
 */
@Stateless
public class LogicaEstudiante implements ILogicaEstudiante {

    @EJB
    public IEstudianteRepo repo;

    public LogicaEstudiante() {
    }

    @Override
    public List<Estudiante> listar() throws NoContentException, NotAllowedException{
        List<Estudiante> estudiantes = new ArrayList();
        estudiantes = repo.listar();
        if(estudiantes.size()> 0 ){
            return estudiantes;
        }else{
            throw new NoContentException("La lista se encuentra vacia"); 
        }
    }

    @Override
    public void guardar(Estudiante estudiante) throws IntegridadException, BadRequestException, NotAllowedException {
        Estudiante ValidarCedulaEstudiante = repo.buscarCedulaEstudiante(estudiante.getCedula());
        if(ValidarCedulaEstudiante == null){
            repo.guardar(estudiante);
        }else{
             throw new IntegridadException("La cedula del estudiante ya existe");
        } 
    }

    @Override
    public void eliminar(int idEstudiante) throws NotFoundObjectException, NotAllowedException {
        Estudiante estudiante = new Estudiante();
        Estudiante eliminarEstudiante = repo.buscarEstudiante(idEstudiante);
        if(eliminarEstudiante == null){
           throw new NotFoundObjectException("No se encontro el estudiante");
        }else{
            repo.eliminar(idEstudiante);
        } 
    }

    @Override
    public void editar(Estudiante estudiante) throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException {
        Estudiante ValidarEstudiante = repo.buscarEstudiante(estudiante.getId());
        if(ValidarEstudiante == null){
            throw new IntegridadException("El estudiante ya existe");        
        }else{
            repo.editar(estudiante);
        }
    }
}
