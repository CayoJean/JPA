package com.egg.servicios;

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

}