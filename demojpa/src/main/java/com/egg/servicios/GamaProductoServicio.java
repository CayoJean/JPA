package com.egg.servicios;

import com.egg.entidades.GamaProducto;
import com.egg.persistencia.GamaProductoDAO;
import java.util.List;

public class GamaProductoServicio {

    private final GamaProductoDAO daoGamaProducto;

    public GamaProductoServicio() {
        this.daoGamaProducto = new GamaProductoDAO();
    }

    // Método para listar e imprimir las gamas de productos
    public void listarGamas() {
        try {
            List<GamaProducto> gamas = daoGamaProducto.listarTodos(); // Llamada al método listarTodos() del DAO
            if (gamas.isEmpty()) {
                System.out.println("No hay gamas de productos disponibles.");
            } else {
                for (GamaProducto gama : gamas) {
                    System.out.println("ID Gama: " + gama.getIdGama() + 
                                        ", Nombre Gama: " + gama.getGama() + 
                                        ", Descripción: " + gama.getDescripcionTexto());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al listar gamas de productos: " + e.getMessage());
        }
    }
}