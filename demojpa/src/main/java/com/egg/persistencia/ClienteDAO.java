package com.egg.persistencia;

import com.egg.entidades.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClienteDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    // PERSISTIR
    public void guardarCliente(Cliente cliente) throws Exception {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    // BUSCAR 1 CLIENTE X ID
    public Cliente buscarCliente(int idCliente) {
        return em.find(Cliente.class, idCliente);
    }

    public void eliminarCliente(int id) throws Exception {
        Cliente cliente = buscarCliente(id);
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
    }
}