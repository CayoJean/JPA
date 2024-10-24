package com.egg.persistencias;

import java.util.List;

import com.egg.entidades.Editorial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EditorialDAO {

    private EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();

    public void crear(Editorial editorial) {
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }

    public Editorial buscarPorId(int id) {
        return em.find(Editorial.class, id);
    }

    public List<Editorial> buscarPorNombre(String nombre) {
        return em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre", Editorial.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }

    public void editar(Editorial editorial) {
        em.getTransaction().begin();
        em.merge(editorial);
        em.getTransaction().commit();
    }

    public void eliminar(int id) {
        em.getTransaction().begin();
        Editorial editorial = em.find(Editorial.class, id);
        if (editorial != null) {
            em.remove(editorial);
        }
        em.getTransaction().commit();
    }
}
