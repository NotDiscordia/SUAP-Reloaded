/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.UI;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.helper.ProfesorHelper;

/**
 *
 * @author Kevin
 */
@ManagedBean(name = "profesorUI")
@ViewScoped
public class ProfesorBeanUI implements Serializable {
    private ProfesorHelper profesorHelper;
    private Profesor profesor;
    private int profesorId; // Para buscar profesor por ID
    private List<Profesor> profesores; // Lista de todos los profesores
    
    public ProfesorBeanUI() {
        profesorHelper = new ProfesorHelper();
    }
    
    @PostConstruct
    public void init() {
        profesor = new Profesor(); // Inicializar profesor vacío
        profesores = profesorHelper.obtenerTodosLosProfesores(); // Obtener todos los profesores al cargar la página
    }
    
    public void buscarProfesor() {
        profesor = profesorHelper.obtenerProfesorPorId(profesorId);
        if (profesor == null) {
            profesor = new Profesor();
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, "Profesor no encontrado", "Verifique el ID"));
        }
    }
    
    public void eliminarProfesor() {
    try {
        if (profesorId > 0) {
            profesorHelper.eliminarProfesor(profesorId);
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Profesor eliminado correctamente."));
            
            // Actualizar la lista de profesores después de eliminar
            profesores = profesorHelper.obtenerTodosLosProfesores();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Ingrese un número de profesor válido."));
        }
    } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar el profesor."));
        e.printStackTrace();
    }
}
    /* Getters y Setters */
    
    public Profesor getProfesor() {
        return profesor;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    public int getProfesorId() {
        return profesorId;
    }
    
    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }
    public void buscarTodos() {
     try {
        profesores = profesorHelper.obtenerTodosLosProfesores();
        if (profesores == null || profesores.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "No hay profesores en la base de datos", ""));
        }
    } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al obtener los profesores", e.getMessage()));
        e.printStackTrace(); // Imprime el error en la consola para depuración
    }
    }
}
