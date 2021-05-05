package edu.unicundi.hospitalejb.repositoryimp;

import edu.unicundi.hospitalejb.entity.Consulta;
import edu.unicundi.hospitalejb.repository.PatronFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

;

/**
 * @author Erika Moreno
 * @author Anderson Nevao
 * @since 25/04/2021
 * @version 1.0.0
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

    public int contarSiExiste(Integer Id) {
        Query query = em.createNamedQuery("Consulta.Count");
        Number numero = (Number) query.getSingleResult();
        return numero.intValue();
    }

    public void eliminarOptimo(Integer idConsulta) {
        Query query = em.createNamedQuery("Consulta.EliminarOptimo");
        query.setParameter("paramId", idConsulta);
        query.executeUpdate();
    }
}
