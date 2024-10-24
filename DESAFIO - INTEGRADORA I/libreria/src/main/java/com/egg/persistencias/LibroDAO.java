package com.egg.persistencias;

import java.util.List;

import com.egg.entidades.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class LibroDAO {

    private EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();

    public void crear(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    public Libro buscarPorIsbn(Long isbn) {
        return em.find(Libro.class, isbn);
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo", Libro.class)
                .setParameter("titulo", titulo)
                .getResultList();
    }

    public List<Libro> buscarPorAutor(String nombreAutor) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre = :nombreAutor", Libro.class)
                .setParameter("nombreAutor", nombreAutor)
                .getResultList();
    }

    public List<Libro> buscarPorEditorial(String nombreEditorial) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre = :nombreEditorial", Libro.class)
                .setParameter("nombreEditorial", nombreEditorial)
                .getResultList();
    }

    public void editar(Libro libro) {
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }

    public void eliminar(Long isbn) {
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, isbn);
        if (libro != null) {
            em.remove(libro);
        }
        em.getTransaction().commit();
    }
}
