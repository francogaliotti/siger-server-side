package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.EstadoBoleta;
import com.SIGER.SIGER.repositories.EstadoBoletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EstadoBoletaSeeder implements CommandLineRunner {


    @Autowired
    EstadoBoletaRepository estadoBoletaRepository;

    @Override
    public void run(String... args) throws Exception {
        loadEstadoBoleta();
    }


    private void loadEstadoBoleta(){
        if (estadoBoletaRepository.count() == 0) {
            estadoBoletaRepository.save(buildEstadoBoleta("EB01", "Pendiente de Aprobación"));
            estadoBoletaRepository.save(buildEstadoBoleta("EB02", "Aprobada"));
            estadoBoletaRepository.save(buildEstadoBoleta("EB03", "Rechazada"));
        }
    }

    private EstadoBoleta buildEstadoBoleta(String codigo, String denominacion){
        return EstadoBoleta.builder()
                .codEstadoBoleta(codigo)
                .nombreEstadoBoleta(denominacion)
                .build();
    }
}

