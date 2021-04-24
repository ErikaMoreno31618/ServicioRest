/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unicundi.repository;

import com.edu.unicundi.entity.Estudiante;
import com.edu.unicundi.exception.BadRequestException;
import com.edu.unicundi.exception.IntegridadException;
import com.edu.unicundi.exception.NoContentException;
import com.edu.unicundi.exception.NotFoundObjectException;
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.NotAllowedException;
/**
 * Interfaz para el repositorio de la clase estudiante
 *
 * @author Erika Moreno
 * @version 1.0.0
 */
@Local
public interface IEstudianteRepo {   
    public List<Estudiante> listar() throws NoContentException, NotAllowedException;
    public void guardar(Estudiante estudiante)throws IntegridadException, BadRequestException, NotAllowedException;
    public void eliminar(int idEstudiante) throws NotFoundObjectException, NotAllowedException;
    public void editar(Estudiante estudiante)throws IntegridadException, NotFoundObjectException, BadRequestException, NotAllowedException;
    public Estudiante buscarCedulaEstudiante(String cedula);
    public Estudiante buscarEstudiante(int id);
}
