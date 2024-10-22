package com.egg.servicios;


import java.util.List;

import com.egg.entidades.Empleado;
import com.egg.persistencia.EmpleadoDAO;

public class EmpleadoServicio {

        private final EmpleadoDAO daoEmpleado;// Instancio a la unidad d persistencia para acceder a los metodos del EM

    public EmpleadoServicio() {
        this.daoEmpleado = new EmpleadoDAO();
    }

    public void eliminar(int id) {
        try {
            daoEmpleado.eliminarEmpleado(id);
            System.out.println("EMPLEADO ELIMINADO CON EXITO");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NO SE ENCONTRO EL EMPLEADO PARA ELIMINAR");
        }

    }




    



     // Método para listar e imprimir empleados
    public void listarEmpleados() {
        try {
            List<Empleado> empleados = daoEmpleado.listarTodos(); // Llamada al método listarTodos() del DAO
            if (empleados.isEmpty()) {
                System.out.println("No hay empleados disponibles.");
            } else {
                for (Empleado empleado : empleados) {
                    System.out.println("ID: " + empleado.getIdEmpleado() + 
                                        ", Nombre: " + empleado.getNombre() + 
                                        ", Apellido: " + empleado.getApellido() +
                                        ", Puesto: " + empleado.getPuesto());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al listar empleados: " + e.getMessage());
        }
    }
}
