///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package com.edu.unicundi.repository.imp;

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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Clase para la logica implementada para las respectivos 
 * querys necesarios para que la peticion que haga el usuario se fectue con exito
 * @author Erika Moreno
 * @version 1.0.0
 */
@Stateless
public class EstudianteRepoImp implements IEstudianteRepo {

    @PersistenceContext(unitName = "com.edu.unicundi_ServiciosRest-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Estudiante> listar() {
        TypedQuery<Estudiante> query = this.em.createQuery("SELECT e from Estudiante e", Estudiante.class);
        return query.getResultList();
    }

    @Override
    public void guardar(Estudiante estudiante) throws IntegridadException, BadRequestException {
        em.persist(estudiante);
    }

    @Override
    public void eliminar(int idEstudiante) throws NotFoundObjectException {
        Estudiante estudiante = em.find(Estudiante.class, idEstudiante);
        em.remove(estudiante);
    }

    @Override
    public void editar(Estudiante estudiante) throws IntegridadException, NotFoundObjectException, BadRequestException {
        em.merge(estudiante);
    }
    
    public Estudiante buscarCedulaEstudiante(String cedula){
        try{
           Query query =em.createQuery("SELECT e from Estudiante e WHERE e.cedula = ?1", Estudiante.class);
           query.setParameter(1, cedula);
           return (Estudiante) query.getSingleResult();
        }catch(NoResultException ex ){
            return null;
        }
    }
    public Estudiante buscarEstudiante(int id){
        try{
           Query query =em.createQuery("SELECT e from Estudiante e WHERE e.id = ?1", Estudiante.class);
           query.setParameter(1, id);
           return (Estudiante) query.getSingleResult();
        }catch(NoResultException ex ){
            return null;
        }
    }
}
