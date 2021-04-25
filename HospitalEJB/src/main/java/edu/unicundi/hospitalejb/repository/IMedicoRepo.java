package edu.unicundi.hospitalejb.repository;

import edu.unicundi.hospitalejb.entity.Medico;
import javax.ejb.Local;


/**
 *
 * @author Erika Moreno
 */
@Local
public interface IMedicoRepo {

    public Medico buscarMedico(int id);
}
