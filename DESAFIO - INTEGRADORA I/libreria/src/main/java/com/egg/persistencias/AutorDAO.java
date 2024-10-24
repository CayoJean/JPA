package com.egg.persistencias;

import java.util.List;

import com.egg.entidades.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class AutorDAO {

    private EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();

    public void crear(Autor autor) {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    public Autor buscarPorId(int id) {
        return em.find(Autor.class, id);
    }

    public List<Autor> buscarPorNombre(String nombre) {
        return em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre", Autor.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }

    public void editar(Autor autor) {
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
    }

    public void eliminar(int id) {
        em.getTransaction().begin();
        Autor autor = em.find(Autor.class, id);
        if (autor != null) {
            em.remove(autor);
        }
        em.getTransaction().commit();
    }
}
