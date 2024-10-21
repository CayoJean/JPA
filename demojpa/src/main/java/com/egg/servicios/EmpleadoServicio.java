package com.egg.servicios;

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
}
