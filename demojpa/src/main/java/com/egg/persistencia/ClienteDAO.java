package com.egg.persistencia;

import com.egg.entidades.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

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

    // NUEVO MÉTODO PARA LISTAR TODOS LOS CLIENTES
    public List<Cliente> listarTodos() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }





    // ✏️Actividad Listar con parámetros 
    public List<Cliente> listarClientesPorNombre(String nombreABuscar) throws Exception {
        return em.createQuery("SELECT c FROM Cliente c WHERE c.nombreContacto LIKE :nombre", Cliente.class)
                .setParameter("nombre", "%" + nombreABuscar + "%")
                .getResultList();
    }







    //Listar Clientes por Ciudad

    // ✏️Actividad Listar con parámetros 

    public List<Cliente> listarClientesPorCiudad(String ciudad) throws Exception {
        return em.createQuery("SELECT c FROM Cliente c WHERE c.ciudad = :ciudad", Cliente.class)
                .setParameter("ciudad", ciudad)
                .getResultList();
    }








    // ✏️Actividad consultas con joins

    // 3. Listar todos los clientes de un empleado de contacto específico
    public List<Cliente> listarClientesPorEmpleadoContacto(String nombreEmpleado) {
        return em.createQuery(
                "SELECT c FROM Cliente c JOIN c.empleado e WHERE e.nombreContacto = :nombreEmpleado", 
                Cliente.class)
                .setParameter("nombreEmpleado", nombreEmpleado)
                .getResultList();
    }

}
