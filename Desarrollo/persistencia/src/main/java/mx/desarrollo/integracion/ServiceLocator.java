/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.integracion;

import mx.desarrollo.DAO.AlumnoDAO;
import mx.desarrollo.DAO.UsuarioDAO;
import mx.desarrollo.DAO.ProfesorDAO;


/**
 *
 * @author total
 */
public class ServiceLocator {
    
    private static AlumnoDAO alumnoDAO;
    private static UsuarioDAO usuarioDAO;
    private static ProfesorDAO profesorDAO;
    /**
     * se crea la instancia para alumno DAO si esta no existe
     */
    public static AlumnoDAO getInstanceAlumnoDAO(){
        if(alumnoDAO == null){
            alumnoDAO = new AlumnoDAO();
            return alumnoDAO;
        } else{
            return alumnoDAO;
        }
    }
    /**
     * se crea la instancia de usuarioDAO si esta no existe
     */
    public static UsuarioDAO getInstanceUsuarioDAO(){
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO();
            return usuarioDAO;
        } else{
            return usuarioDAO;
        }
    }
    
    public static ProfesorDAO getInstanceProfesorDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO();
            return profesorDAO;
        } else{
            return profesorDAO;
        }
    }
    
}
