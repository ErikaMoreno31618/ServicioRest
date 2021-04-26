package edu.unicundi.hospitalejb.repository;

import edu.unicundi.hospitalejb.entity.Medico;
import javax.ejb.Local;


/**
 * @author Erika Moreno
 * @author Anderson Nevao
 * @since  25/04/2021 
 * @version 1.0.0
 */
@Local
public interface IMedicoRepo {

    public Medico buscarMedico(int id);
}
