/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospitalejb.repository;

import edu.unicundi.hospitalejb.exception.BadRequestException;
import edu.unicundi.hospitalejb.exception.IntegridadException;
import edu.unicundi.hospitalejb.exception.NoContentException;
import edu.unicundi.hospitalejb.exception.NotFoundObjectException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.NotAllowedException;

/**
 *
 * @author Erika Moreno
 * @param <T>
 */
public abstract class PatronFacade<T> {

    protected abstract EntityManager getEntityManager();
    private Class<T> entityClass;

    public PatronFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T buscarporId(Object id) throws NotAllowedException {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> listar() throws NoContentException, NotAllowedException {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().
                getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public void guardar(T entity) throws IntegridadException, BadRequestException, NotAllowedException {
        getEntityManager().persist(entity);
    }

    public T editar(T entity)throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException {
        return getEntityManager().merge(entity);
    }

    public void eliminar(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
}
