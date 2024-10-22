package com.egg.persistencia;

import com.egg.entidades.GamaProducto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class GamaProductoDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    // Método para listar todas las gamas de productos
    public List<GamaProducto> listarTodos() {
        return em.createQuery("SELECT g FROM GamaProducto g", GamaProducto.class).getResultList();
    }
}