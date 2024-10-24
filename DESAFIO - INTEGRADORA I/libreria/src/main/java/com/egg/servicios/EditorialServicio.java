package com.egg.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

import com.egg.entidades.Editorial;

public class EditorialServicio {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreriaPU");

    public void crearEditorial(String nombre) {
        EntityManager em = emf.createEntityManager();
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setAlta(true);

        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
        em.close();
    }

    public Editorial buscarEditorialPorId(Integer id) {
        EntityManager em = emf.createEntityManager();
        Editorial editorial = em.find(Editorial.class, id);
        em.close();
        return editorial;
    }

    public List<Editorial> listarEditoriales() {
        EntityManager em = emf.createEntityManager();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e", Editorial.class).getResultList();
        em.close();
        return editoriales;
    }

    public void modificarEditorial(Integer id, String nuevoNombre) {
        EntityManager em = emf.createEntityManager();
        Editorial editorial = em.find(Editorial.class, id);
        if (editorial != null) {
            em.getTransaction().begin();
            editorial.setNombre(nuevoNombre);
            em.getTransaction().commit();
        }
        em.close();
    }

    public void darBajaEditorial(Integer id) {
        EntityManager em = emf.createEntityManager();
        Editorial editorial = em.find(Editorial.class, id);
        if (editorial != null) {
            em.getTransaction().begin();
            editorial.setAlta(false);
            em.getTransaction().commit();
        }
        em.close();
    }

    public void eliminarEditorial(Integer id) {
        EntityManager em = emf.createEntityManager();
        Editorial editorial = em.find(Editorial.class, id);
        if (editorial != null) {
            em.getTransaction().begin();
            em.remove(editorial);
            em.getTransaction().commit();
        }
        em.close();
    }
}
