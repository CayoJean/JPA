package com.egg.persistencia;

import com.egg.entidades.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ProductoDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    // Método para listar todos los productos
    public List<Producto> listarTodos() {
        return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }








    // ✏️Actividad consultas con joins
    

    // 1. Listar todos los productos que en su detalle tengan un producto específico
    public List<Producto> listarProductosPorNombre(String nombreProducto) {
        return em.createQuery(
                "SELECT p FROM Producto p JOIN p.detalles d WHERE d.producto.nombre = :nombre", 
                Producto.class)
                .setParameter("nombre", nombreProducto)
                .getResultList();
    }

    // 6. Listar los 10 productos más vendidos en los pedidos
    public List<Producto> listarProductosMasVendidos(int limite) {
        return em.createQuery(
                "SELECT p FROM Producto p JOIN p.detalles d GROUP BY p ORDER BY SUM(d.cantidad) DESC", 
                Producto.class)
                .setMaxResults(limite)
                .getResultList();
    }
}
