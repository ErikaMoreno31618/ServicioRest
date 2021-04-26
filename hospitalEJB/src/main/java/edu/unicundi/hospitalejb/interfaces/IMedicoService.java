/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospitalejb.interfaces;

import edu.unicundi.hospitalejb.entity.Medico;
import edu.unicundi.hospitalejb.exception.BadRequestException;
import edu.unicundi.hospitalejb.exception.IntegridadException;
import edu.unicundi.hospitalejb.exception.NoContentException;
import edu.unicundi.hospitalejb.exception.NotFoundObjectException;
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.NotAllowedException;

/**
 * @author Erika Moreno
 * @author Anderson Nevao
 * @since  25/04/2021 
 * @version 1.0.0
 */
@Local
public interface IMedicoService {
    public List<Medico> listar() throws NoContentException, NotAllowedException;
    public Medico BuscarPorId(Integer id) throws NoContentException, NotAllowedException, NotFoundObjectException;
    public void guardar(Medico medico)throws IntegridadException, BadRequestException, NotAllowedException;
    public void eliminar(Integer idMedico) throws NotFoundObjectException, NotAllowedException;
    public void editar(Medico medico)throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException;
    public Medico buscarMedico(int id);
}
