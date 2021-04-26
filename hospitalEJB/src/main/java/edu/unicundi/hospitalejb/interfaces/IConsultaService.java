/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospitalejb.interfaces;

import edu.unicundi.hospitalejb.entity.Consulta;
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
public interface IConsultaService {
    public List<Consulta> listar() throws NoContentException, NotAllowedException;
    public Consulta BuscarPorId(Integer id) throws NoContentException, NotAllowedException, NotFoundObjectException;
    public void guardar(Consulta consulta)throws IntegridadException, BadRequestException, NotAllowedException;
    public void eliminar(Integer idConsulta) throws NotFoundObjectException, NotAllowedException;
    public void editar(Consulta consulta)throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException;
}
