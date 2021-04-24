/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unicundi.interfaces;

import com.edu.unicundi.entity.Consulta;
import com.edu.unicundi.exception.BadRequestException;
import com.edu.unicundi.exception.IntegridadException;
import com.edu.unicundi.exception.NoContentException;
import com.edu.unicundi.exception.NotFoundObjectException;
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.NotAllowedException;

/**
 *
 * @author Erika Moreno
 */
@Local
public interface IConsultaService {
    public List<Consulta> listar() throws NoContentException, NotAllowedException;
    public Consulta BuscarPorId(Integer id) throws NoContentException, NotAllowedException, NotFoundObjectException;
    public void guardar(Consulta consulta)throws IntegridadException, BadRequestException, NotAllowedException;
    public void eliminar(Integer idConsulta) throws NotFoundObjectException, NotAllowedException;
    public void editar(Consulta consulta)throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException;
}
