/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.persistencia.AbstractDAO;

public class ProfesorDAO extends AbstractDAO<Integer, Profesor> {
    
    public void eliminarProfesor(Integer numProfesor) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            Profesor profesor = em.find(Profesor.class, numProfesor);
            if (profesor != null) {
                em.remove(profesor);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
