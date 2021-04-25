
package edu.unicundi.hospitalejb.repositoryimp;

import edu.unicundi.hospitalejb.entity.Consulta;
import edu.unicundi.hospitalejb.exception.NotFoundObjectException;
import edu.unicundi.hospitalejb.repository.IConsultaRepo;
import edu.unicundi.hospitalejb.repository.PatronFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


/**
 *
 * @author Erika Moreno
 */
@Stateless
public class ConsultaRepoImp extends PatronFacade<Consulta> implements IConsultaRepo {

    @PersistenceContext(unitName = "base")
    private EntityManager em;

    public ConsultaRepoImp() {
        super(Consulta.class);
    }

     @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    @Override
    public Consulta buscarConsulta(int id) throws NotFoundObjectException {

        Query query = em.createQuery("SELECT e from Consulta e WHERE e.id = ?1", Consulta.class);
        query.setParameter(1, id);
        return (Consulta) query.getSingleResult();

    }
}
