///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.edu.unicundi.service;
//
//import com.edu.unicundi.entity.Estudiante;
////import com.edu.unicundi.exception.IntegridadException;
////import com.edu.unicundi.exception.NoContentException;
////import com.edu.unicundi.exception.NotFoundObjectException;
//import com.edu.unicundi.interfaces.ILogicaEstudiante;
//import java.util.ArrayList;
//import java.util.List;
////import java.util.List;
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
////import javax.ws.rs.NotFoundException;
//
///**
// *
// * @author Erika Moreno
// */
//@Stateless
//public class EstudianteServiceImp {
//    
//    @EJB
//    private ILogicaEstudiante repo;
//    List<Estudiante> estudiantes = new ArrayList();
//
//    
//    public void guardar(Estudiante estudiante) {
//         for (int i = 0; i < estudiantes.size(); i++) {
//            if (estudiantes.get(i).getCedula().equals(estudiante.getCedula()) == true) {
//              // throw new IntegridadException("La cedula del estudiante ya existe");
//            } else if (estudiantes.get(i).getId().equals(estudiante.getId()) == true) {
//              //  throw new IntegridadException("el ID del estudiante ya existe");
//            }
//        }
//        repo.guardar(estudiante);
//    }
//
//  
//    public void eliminar(int id) {
//        repo.eliminar(id);
//    }
//
//   
//    public List<Estudiante> estudiante() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//   
//    public void editar(Estudiante estdnt) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//  
//}
