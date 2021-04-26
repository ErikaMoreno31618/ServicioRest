/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospitalejb.repositoryimp;

import edu.unicundi.hospitalejb.entity.Medico;
import edu.unicundi.hospitalejb.repository.PatronFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * @author Erika Moreno
 * @author Anderson Nevao
 * @since  25/04/2021 
 * @version 1.0.0
 */
@Stateless
public class MedicoRepoImp extends PatronFacade<Medico>  {

    @PersistenceContext(unitName = "base")
    private EntityManager em;

    public MedicoRepoImp() {
        super(Medico.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


}
