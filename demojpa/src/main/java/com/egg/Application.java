/*
package com.egg;

public class Application {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("\nHello World!");
    }
}
*/


/* 
package com.egg;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
        EntityManager em = emf.createEntityManager();

        // Cerrar el EntityManager cuando ya no se necesita
        em.close();
        // Cerrar la instancia de EntityManagerFactory cuando ya no se necesita
        emf.close();

    }
}
*/

package com.egg;

import java.util.Date;
import java.util.List;

//import java.util.Date;






import com.egg.entidades.Cliente;
import com.egg.entidades.Empleado;
import com.egg.entidades.Pago;
import com.egg.entidades.Pedido;
import com.egg.entidades.Producto;
//import com.egg.entidades.Pedido;
import com.egg.persistencia.ClienteDAO;
import com.egg.persistencia.EmpleadoDAO;
import com.egg.persistencia.PagoDAO;
import com.egg.persistencia.PedidoDAO;
import com.egg.persistencia.ProductoDAO;
//import com.egg.persistencia.PedidoDAO;
//import com.egg.servicios.ClienteServicio;
//import com.egg.servicios.EmpleadoServicio;
//import com.egg.servicios.GamaProductoServicio;
//import com.egg.entidades.Cliente;
//import com.egg.servicios.ClienteServicio;
//import com.egg.servicios.EmpleadoServicio;
import com.egg.servicios.OficinaServicio;
//import com.egg.servicios.ProductoServicio;

public class Application {

    public static void main(String[] args) {
        
        OficinaServicio oficinaServicio = new OficinaServicio();
        //ClienteServicio clienteServicio = new ClienteServicio();
        //EmpleadoServicio empleadoServicio = new EmpleadoServicio();

        // PRUEBA PARA CREAR UNA NUEVA OFICINA



        // oficinaServicio.crearOficna("OFI04", "Mendoza", "Argentina", "Cuyo", "33333333","CP5000");




        // PRUEBA PARA CREAR UN NUEVO CLIENTE
        //clienteServicio.crearCliente(28, "PruebaCliente1", "PruebaCliente1", "PruebaCliente1", "11111111",
                //"11111111", "CiudadPrueba", "RegionPrueba", "PaisPrueba", "CPPrueba", 5, 500000.00);

        // PRUEBA PARA BUSCAR UN CLIENTE (con id existente en BBDD)
        //Cliente buscado = clienteServicio.buscarCliente(5);
        //System.out.println(buscado.toString());

        // ELIMINAR EMPLEADO (con id 1)
        //empleadoServicio.eliminar(1);

        // Llamada para listar todas las oficinas disponibles
        try {
            System.out.println("********OFICINAS DISPONIBLES********");
            System.out.println("ID OFICINA // CIUDAD OFICINA // PAIS OFICINA");
            oficinaServicio.listarOficinas();  // Llamada al método que lista oficinas
        } catch (Exception e) {
            System.out.println("Error al listar oficinas: " + e.getMessage());
        }




        
         /*
        ClienteServicio clienteServicio = new ClienteServicio();
        EmpleadoServicio empleadoServicio = new EmpleadoServicio();
        ProductoServicio productoServicio = new ProductoServicio();
        GamaProductoServicio gamaProductoServicio = new GamaProductoServicio();

        
        // Listar clientes con manejo de excepciones
        try {
            System.out.println("********CLIENTES********");
            clienteServicio.listarClientes();
        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }

        // Listar productos con manejo de excepciones
        try {
            System.out.println("********PRODUCTOS********");
            productoServicio.listarProductos();
        } catch (Exception e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }

        // Listar gamas de productos con manejo de excepciones
        try {
            System.out.println("********GAMAS DE PRODUCTOS********");
            gamaProductoServicio.listarGamas();
        } catch (Exception e) {
            System.out.println("Error al listar gamas de productos: " + e.getMessage());
        }

        // Listar empleados con manejo de excepciones
        try {
            System.out.println("********EMPLEADOS********");
            empleadoServicio.listarEmpleados();
        } catch (Exception e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
    }
     */


     try {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> clientesPorNombre = clienteDAO.listarClientesPorNombre("Juan"); // Cambia "Juan" por el nombre que desees.
        
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> empleadosPorOficina = empleadoDAO.listarEmpleadosPorIdOficina(1); // Cambia 1 por el ID de oficina deseado.

        //PedidoDAO pedidoDAO = new PedidoDAO();
        //List<Pedido> pedidosPorFecha = pedidoDAO.listarPedidosPorFechaEntrega(new Date()); // Cambia por la fecha que necesites.

        // Imprimir resultados
        System.out.println("Clientes encontrados: " + clientesPorNombre.size());
        System.out.println("Empleados encontrados: " + empleadosPorOficina.size());
        //System.out.println("Pedidos encontrados: " + pedidosPorFecha.size());
    } catch (Exception e) {
        e.printStackTrace();
    }






    // ✏️Actividad consultas con joins

    // Invocacion de los metodos de Joins

    ProductoDAO productoDAO = new ProductoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        PagoDAO pagoDAO = new PagoDAO();

        // Aquí invocas tus métodos como se describió anteriormente
        // Ejemplo de uso
        List<Producto> productos = productoDAO.listarProductosPorNombre("ProductoX");
        System.out.println("Productos encontrados: " + productos.size());

        List<Pedido> pedidos = pedidoDAO.listarPedidosPorNombreClienteYFechas("ClienteY", new Date(), new Date());
        System.out.println("Pedidos encontrados: " + pedidos.size());

        List<Cliente> clientes = clienteDAO.listarClientesPorEmpleadoContacto("EmpleadoZ");
        System.out.println("Clientes encontrados: " + clientes.size());

        List<Empleado> empleados = empleadoDAO.listarEmpleadosPorOficina("OficinaA");
        System.out.println("Empleados encontrados: " + empleados.size());

        List<Empleado> jefes = empleadoDAO.listarEmpleadosJefes();
        System.out.println("Jefes encontrados: " + jefes.size());

        List<Producto> productosMasVendidos = productoDAO.listarProductosMasVendidos(10);
        System.out.println("Productos más vendidos: " + productosMasVendidos.size());

        List<Pago> pagos = pagoDAO.listarPagosPorFechas(new Date(), new Date());
        System.out.println("Pagos encontrados: " + pagos.size());
    }
}
