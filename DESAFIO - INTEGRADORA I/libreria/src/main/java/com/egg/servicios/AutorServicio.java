package com.egg.servicios;

import com.egg.entidades.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AutorServicio {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreriaPU");

    public void crearAutor(String nombre) {
        EntityManager em = emf.createEntityManager();
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(true);

        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        em.close();
    }

    public Autor buscarAutorPorId(Integer id) {
        EntityManager em = emf.createEntityManager();
        Autor autor = em.find(Autor.class, id);
        em.close();
        return autor;
    }

    public List<Autor> listarAutores() {
        EntityManager em = emf.createEntityManager();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
        em.close();
        return autores;
    }

    public void modificarAutor(Integer id, String nuevoNombre) {
        EntityManager em = emf.createEntityManager();
        Autor autor = em.find(Autor.class, id);
        if (autor != null) {
            em.getTransaction().begin();
            autor.setNombre(nuevoNombre);
            em.getTransaction().commit();
        }
        em.close();
    }

    public void darBajaAutor(Integer id) {
        EntityManager em = emf.createEntityManager();
        Autor autor = em.find(Autor.class, id);
        if (autor != null) {
            em.getTransaction().begin();
            autor.setAlta(false);
            em.getTransaction().commit();
        }
        em.close();
    }

    public void eliminarAutor(Integer id) {
        EntityManager em = emf.createEntityManager();
        Autor autor = em.find(Autor.class, id);
        if (autor != null) {
            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();
        }
        em.close();
    }
}