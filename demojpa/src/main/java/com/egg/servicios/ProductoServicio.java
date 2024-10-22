package com.egg.servicios;

import com.egg.entidades.Producto;
import com.egg.persistencia.ProductoDAO;
import java.util.List;

public class ProductoServicio {

    private final ProductoDAO daoProducto;

    public ProductoServicio() {
        this.daoProducto = new ProductoDAO();
    }

    // Método para listar e imprimir productos
    public void listarProductos() throws Exception {
        List<Producto> productos = daoProducto.listarTodos(); // Método que obtiene todos los productos
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            for (Producto producto : productos) {
                System.out.println("Código: " + producto.getCodigoProducto() +
                                    ", Nombre: " + producto.getNombre() +
                                    ", Precio: " + producto.getPrecioVenta());
            }
        }
    }
}
