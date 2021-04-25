package edu.unicundi.hospitalejb.repository;

import edu.unicundi.hospitalejb.entity.Consulta;
import edu.unicundi.hospitalejb.exception.NotFoundObjectException;
import javax.ejb.Local;

/**
 *
 * @author Erika Moreno
 */
@Local
public interface IConsultaRepo {

    public Consulta buscarConsulta(int id) throws NotFoundObjectException;
}
