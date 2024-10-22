
/*
package com.egg.persistencia; // Asegúrate de que esto sea correcto


import java.util.Date;
import java.util.List;

import com.egg.entidades.Pedido;

public class PedidoDAO {

    

    public List<Pedido> listarPedidosPorFechaEntrega(Date fechaEsperada) throws Exception {
        return em.createQuery("SELECT p FROM Pedido p WHERE p.fechaEntrega > :fechaEsperada", Pedido.class)
                .setParameter("fechaEsperada", fechaEsperada)
                .getResultList();
    }
}
*/





// ✏️Actividad consultas con joins

package com.egg.persistencia;



import com.egg.entidades.Pedido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;

public class PedidoDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    // 2. Listar todos los pedidos de un cliente en un rango de fechas
    public List<Pedido> listarPedidosPorNombreClienteYFechas(String nombreCliente, Date fechaInicio, Date fechaFin) {
        return em.createQuery(
                "SELECT p FROM Pedido p JOIN p.cliente c WHERE c.nombre = :nombreCliente AND p.fecha BETWEEN :fechaInicio AND :fechaFin", 
                Pedido.class)
                .setParameter("nombreCliente", nombreCliente)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();
    }
}
