package com.egg.servicios;

import java.util.List;

import com.egg.entidades.Cliente;
import com.egg.persistencia.ClienteDAO;

public class ClienteServicio {
    private final ClienteDAO daoCliente;// Instancio a la unidad d persistencia para acceder a los metodos del EM

    public ClienteServicio() {
        this.daoCliente = new ClienteDAO();
    }

    public void crearCliente(int codigoCliente, String nombreCliente, String nombreContacto, String apellidoContacto,
            String telefono, String fax, String ciudad, String region, String pais,
            String codigoPostal, int idEmpleado, double limiteCredito) {
        try {

            Cliente clienteNuevo = new Cliente();

            clienteNuevo.setCodigoCliente(codigoCliente);
            clienteNuevo.setNombreCliente(nombreCliente);
            clienteNuevo.setNombreContacto(nombreContacto);
            clienteNuevo.setApellidoContacto(apellidoContacto);
            clienteNuevo.setTelefono(telefono);
            clienteNuevo.setFax(fax);
            clienteNuevo.setCiudad(ciudad);
            clienteNuevo.setRegion(region);
            clienteNuevo.setPais(pais);
            clienteNuevo.setCodigoPostal(codigoPostal);
            clienteNuevo.setIdEmpleado(idEmpleado);
            clienteNuevo.setLimite_credito(limiteCredito);

            daoCliente.guardarCliente(clienteNuevo);
        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo el cliente  de manera correcta");
        }

    }

    // Método para buscar un cliente por su código (FIND)
    public Cliente buscarCliente(int idCliente) {
        Cliente cliente = daoCliente.buscarCliente(idCliente);
        try {
            if (cliente == null) {
                System.out.println("No existe un cliente con el ID proporcionado: " + idCliente);
            }

            return cliente;

        } catch (

        Exception e) {
            System.out.println("Ocurrió un error al buscar el cliente: " + e.getMessage());
        }
        return null;
    }










    // Método para listar todos los clientes
    
    public List<Cliente> obtenerTodosLosClientes() throws Exception {
        return daoCliente.listarTodos(); // Llamada al método listarTodos() del DAO
    }

    // Método para listar e imprimir los clientes
    public void listarClientes() throws Exception {
        List<Cliente> clientes = obtenerTodosLosClientes(); // Obtener todos los clientes
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getIdCliente() + 
                                ", Nombre: " + cliente.getNombreCliente() + 
                                ", Apellido: " + cliente.getApellidoContacto() + 
                                ", Ciudad: " + cliente.getCiudad() +
                                ", País: " + cliente.getPais());
        }
    }







    public void listarClientes(String nombreRecibido) throws Exception {
        List<Cliente> clientesNombre = daoCliente.listarClientesPorNombre(nombreRecibido);
        imprimirLista(clientesNombre);
    }



    //✏️Actividad Listar con parámetros 
    
    // Imprimo solo lgunos datos de la BBDD
    public void imprimirLista(List<Cliente> listaRecibida) {
        for (Cliente unitarioCliente : listaRecibida) {
            System.out.println(unitarioCliente.getIdCliente() + "-" + unitarioCliente.getApellidoContacto() + "-"
                    + unitarioCliente.getNombreContacto());
        }


    }
}