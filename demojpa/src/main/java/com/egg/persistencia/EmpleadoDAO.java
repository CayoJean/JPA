package com.egg.persistencia;

import com.egg.entidades.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpleadoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void eliminarEmpleado(int idEmpleado) throws Exception {
        Empleado empleado = buscarEmpleado(idEmpleado);
        em.getTransaction().begin();
        em.remove(empleado);
        em.getTransaction().commit();
    }

    public Empleado buscarEmpleado(int idEmpleado) {
        return em.find(Empleado.class, idEmpleado);
    }
}