/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospitalejb.repositoryimp;

import edu.unicundi.hospitalejb.entity.Medico;
import edu.unicundi.hospitalejb.exception.BadRequestException;
import edu.unicundi.hospitalejb.exception.IntegridadException;
import edu.unicundi.hospitalejb.exception.NoContentException;
import edu.unicundi.hospitalejb.exception.NotFoundObjectException;
import edu.unicundi.hospitalejb.repository.IMedicoRepo;
import edu.unicundi.hospitalejb.repository.PatronFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotAllowedException;

/**
 *
 * @author Erika Moreno
 */
@Stateless
public class MedicoRepoImp extends PatronFacade<Medico> implements IMedicoRepo {

    @PersistenceContext(unitName = "base")
    private EntityManager em;

    public MedicoRepoImp() {
        super(Medico.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Medico buscarMedico(int id) {
        try {
            Query query = em.createQuery("SELECT e from Medico e WHERE e.id = ?1", Medico.class);
            query.setParameter(1, id);
            return (Medico) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
