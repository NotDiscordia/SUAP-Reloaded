/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mx.desarrollo.delegate.DelegateProfesor;
import mx.desarrollo.entidad.Profesor;
import java.util.List;

public class FacadeProfesor {

    @PersistenceContext
    private EntityManager em;  // Inyección del EntityManager

    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }

    public void guardarProfesor(Profesor profesor) {
        delegateProfesor.saveProfesor(profesor);
    }

    public Profesor buscarPorId(int id) {
        return delegateProfesor.findProfesorById(id);
    }

    public void guardar(Profesor profesor) {
        delegateProfesor.saveProfesor(profesor);
    }

    public void eliminar(int id) {
        delegateProfesor.deleteProfesor(id);
    }

    public List<Profesor> buscarTodos() {
        TypedQuery<Profesor> query = em.createNamedQuery("Profesor.findAll", Profesor.class);
        return query.getResultList();
    }
}
