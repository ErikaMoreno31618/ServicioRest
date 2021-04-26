package edu.unicundi.hospitalejb.repository;

import edu.unicundi.hospitalejb.entity.Consulta;
import edu.unicundi.hospitalejb.exception.NotFoundObjectException;
import javax.ejb.Local;

/**
 * @author Erika Moreno
 * @author Anderson Nevao
 * @since  25/04/2021 
 * @version 1.0.0
 */
@Local
public interface IConsultaRepo {

    public Consulta buscarConsulta(int id) throws NotFoundObjectException;
}
