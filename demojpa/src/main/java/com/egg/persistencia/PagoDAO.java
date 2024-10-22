package com.egg.persistencia;

// 7. Listar todos los pagos que se hicieron entre un rango de fechas



import com.egg.entidades.Pago;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;

public class PagoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    // 7. Listar todos los pagos que se hicieron entre un rango de fechas
    public List<Pago> listarPagosPorFechas(Date fechaInicio, Date fechaFin) {
        return em.createQuery(
                "SELECT pa FROM Pago pa WHERE pa.fecha BETWEEN :fechaInicio AND :fechaFin", 
                Pago.class)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();
    }
}
