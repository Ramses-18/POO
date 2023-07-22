/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tomyv
 * @param <T>
 */
public abstract class DAO<T> {

    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LibraryPU");
    protected EntityManager em = EMF.createEntityManager();

    protected void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void guardar(T t) {
        try {
            conectar();
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }

    protected void eliminar(T t) {
        try {
            conectar();
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }

    protected void editar(T t) {
        try {
            conectar();
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            throw e;
        }
    }

}
