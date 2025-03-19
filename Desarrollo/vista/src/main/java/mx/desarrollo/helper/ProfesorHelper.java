/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import java.io.Serializable;
import java.util.List;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.facade.FacadeProfesor;
import mx.desarrollo.integracion.ServiceFacadeLocator;

/**
 *
 * @author Kevin
 */
public class ProfesorHelper implements Serializable {
    
    /**
     * Metodo para obtener un profesor por su ID
     * @param id
     * @return Profesor encontrado o null si no existe
     */
    public Profesor obtenerProfesorPorId(int id) {
        return ServiceFacadeLocator.getInstanceFacadeProfesor().buscarPorId(id);
    }
    
    /**
     * Metodo para guardar un profesor
     * @param profesor
     */
    public void guardarProfesor(Profesor profesor) {
        ServiceFacadeLocator.getInstanceFacadeProfesor().guardar(profesor);
    }
    
    /**
     * Metodo para eliminar un profesor por su ID
     * @param id
     */
    public void eliminarProfesor(int id) {
        FacadeProfesor facadeProfesor = new FacadeProfesor();
        facadeProfesor.eliminar(id);
    }
    
    public List<Profesor> obtenerTodosLosProfesores() {
        return ServiceFacadeLocator.getInstanceFacadeProfesor().buscarTodos();
    }
    
}
