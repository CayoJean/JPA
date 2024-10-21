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


import com.egg.entidades.Cliente;
import com.egg.servicios.ClienteServicio;
import com.egg.servicios.EmpleadoServicio;
import com.egg.servicios.OficinaServicio;

public class Application {

    public static void main(String[] args) {
        
        OficinaServicio oficinaServicio = new OficinaServicio();
        ClienteServicio clienteServicio = new ClienteServicio();
        EmpleadoServicio empleadoServicio = new EmpleadoServicio();

    
        //PRUEBA PARA CREAR UNA NUEVA OFICINA
        oficinaServicio.crearOficna("OFI04", "Mendoza", "Argentina", "Cuyo", "33333333",
                "CP5000");

        //PRUEBA PARA CREAR UN NUEVO CLIENTE
        clienteServicio.crearCliente(28,"PruebaCliente1","PruebaCliente1","PruebaCliente1","11111111",
        "11111111","CiudadPrueba","RegionPrueba","PaisPrueba","CPPrueba",5,500000.00);
        //PRUEBA PARA BUSCAR UN  CLIENTE (con id existente en BBDD)
        Cliente buscado =clienteServicio.buscarCliente(5);
        System.out.println(buscado.toString());
        
        empleadoServicio.eliminar(1);
    }
}
