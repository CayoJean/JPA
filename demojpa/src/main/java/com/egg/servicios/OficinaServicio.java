package com.egg.servicios;

import com.egg.entidades.Oficina;
import com.egg.persistencia.OficinaDAO;
import java.util.List;

public class OficinaServicio {

    private final OficinaDAO daoOficina; // Instancio a la unidad de persistencia para acceder a los métodos del EM

    public OficinaServicio() {
        this.daoOficina = new OficinaDAO();
    }

    // Método para crear una nueva oficina
    public void crearOficna(String codigodOficina, String ciudad, String pais,
            String region, String telefono, String codigoPostal) {

        try {
            // Crear una nueva instancia de Oficina
            Oficina oficinaNueva = new Oficina();

            oficinaNueva.setCodigodOficina(codigodOficina);
            oficinaNueva.setCiudad(ciudad);
            oficinaNueva.setPais(pais);
            oficinaNueva.setRegion(region);
            oficinaNueva.setTelefono(telefono);
            oficinaNueva.setCodigoPostal(codigoPostal);

            // Llamar al método de OficinaDAO para guardar la nueva oficina
            daoOficina.guardaOficina(oficinaNueva);

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardó la nueva oficina de manera correcta");
        }
    }

    // Método para listar todas las oficinas
    public void listarOficinas() throws Exception {
        List<Oficina> todasOficinas = daoOficina.listarTodas();
        imprimirLista(todasOficinas);
    }

    // Método para imprimir la lista de oficinas
    public void imprimirLista(List<Oficina> listaRecibida) {
        for (Oficina unitariaOficina : listaRecibida) {
            System.out.println(unitariaOficina.getCodigodOficina() + " - " 
                + unitariaOficina.getCiudad() + " - " 
                + unitariaOficina.getPais());
        }
    }
}
