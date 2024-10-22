package com.egg.persistencia;

import com.egg.entidades.Oficina;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List; // Importar la clase List para manejar listas

public class OficinaDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    // Método para guardar una oficina en la base de datos
    public void guardaOficina(Oficina oficina) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(oficina);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback(); // Hacer rollback en caso de error
            throw e; // Lanza la excepción para manejarla en otro lugar si es necesario
        }
    }

    // Método para listar todas las oficinas
    public List<Oficina> listarTodas() throws Exception {
        try {
            return em.createQuery("SELECT o FROM Oficina o", Oficina.class).getResultList();
        } catch (Exception e) {
            throw e; // Lanza la excepción para manejarla en otro lugar si es necesario
        }
    }
}
