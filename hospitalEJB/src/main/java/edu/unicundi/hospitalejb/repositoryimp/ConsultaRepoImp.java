
package edu.unicundi.hospitalejb.repositoryimp;

import edu.unicundi.hospitalejb.entity.Consulta;
import edu.unicundi.hospitalejb.repository.PatronFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
;


/**
 *
 * @author Erika Moreno
 */
@Stateless
public class ConsultaRepoImp extends PatronFacade<Consulta> {

    @PersistenceContext(unitName = "base")
    private EntityManager em;

    public ConsultaRepoImp() {
        super(Consulta.class);
    }

     @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    

}
