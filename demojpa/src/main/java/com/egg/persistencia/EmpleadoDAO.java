package com.egg.persistencia;

import java.util.List;

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






    // Método para listar todos los empleados
    public List<Empleado> listarTodos() {
        return em.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
    }





    //Listar Empleados por ID de Oficina

    // ✏️Actividad Listar con parámetros 
    public List<Empleado> listarEmpleadosPorIdOficina(int idOficina) throws Exception {
        return em.createQuery("SELECT e FROM Empleado e WHERE e.oficina.id = :idOficina", Empleado.class)
                .setParameter("idOficina", idOficina)
                .getResultList();
    }






    // ✏️Actividad consultas con joins

    // 4. Listar todos los empleados de una oficina específica
    public List<Empleado> listarEmpleadosPorOficina(String codigoOficina) {
        return em.createQuery(
                "SELECT e FROM Empleado e JOIN e.oficina o WHERE o.codigo = :codigoOficina", 
                Empleado.class)
                .setParameter("codigoOficina", codigoOficina)
                .getResultList();
    }

    // 5. Listar todos los empleados que son jefes
    public List<Empleado> listarEmpleadosJefes() {
        return em.createQuery(
                "SELECT e FROM Empleado e WHERE e.esJefe = true", 
                Empleado.class)
                .getResultList();
    }
}