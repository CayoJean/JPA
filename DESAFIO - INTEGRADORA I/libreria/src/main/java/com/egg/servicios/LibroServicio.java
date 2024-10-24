package com.egg.servicios;

import com.egg.entidades.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

import com.egg.entidades.Autor;
import com.egg.entidades.Editorial;

public class LibroServicio {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreriaPU");

    public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer autorId, Integer editorialId) {
        EntityManager em = emf.createEntityManager();
        Autor autor = em.find(Autor.class, autorId);
        Editorial editorial = em.find(Editorial.class, editorialId);

        if (autor == null || editorial == null) {
            System.out.println("Autor o Editorial no encontrados.");
            return;
        }

        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setAlta(true);
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        em.close();
    }

    public Libro buscarLibroPorIsbn(Long isbn) {
        EntityManager em = emf.createEntityManager();
        Libro libro = em.find(Libro.class, isbn);
        em.close();
        return libro;
    }

    public List<Libro> listarLibros() {
        EntityManager em = emf.createEntityManager();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        em.close();
        return libros;
    }

    public void modificarLibro(Long isbn, String nuevoTitulo) {
        EntityManager em = emf.createEntityManager();
        Libro libro = em.find(Libro.class, isbn);
        if (libro != null) {
            em.getTransaction().begin();
            libro.setTitulo(nuevoTitulo);
            em.getTransaction().commit();
        }
        em.close();
    }

    public void darBajaLibro(Long isbn) {
        EntityManager em = emf.createEntityManager();
        Libro libro = em.find(Libro.class, isbn);
        if (libro != null) {
            em.getTransaction().begin();
            libro.setAlta(false);
            em.getTransaction().commit();
        }
        em.close();
    }

    public void eliminarLibro(Long isbn) {
        EntityManager em = emf.createEntityManager();
        Libro libro = em.find(Libro.class, isbn);
        if (libro != null) {
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
        }
        em.close();
    }
}
