package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.EstadoLicencia;
import com.SIGER.SIGER.repositories.EstadoLicenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EstadoLicenciaSeeder implements CommandLineRunner {


    @Autowired
    EstadoLicenciaRepository estadoLicenciaRepository;

    @Override
    public void run(String... args) throws Exception {
        loadEstadoLicencia();
    }


    private void loadEstadoLicencia(){
        if (estadoLicenciaRepository.count() == 0) {
            estadoLicenciaRepository.save(buildEstadoLicencia("EL01", "Pendiente de Aprobación"));
            estadoLicenciaRepository.save(buildEstadoLicencia("EL02", "Aprobada"));
            estadoLicenciaRepository.save(buildEstadoLicencia("EL03", "Rechazada"));
        }
    }

    private EstadoLicencia buildEstadoLicencia(String codigo, String denominacion){
        return EstadoLicencia.builder()
                .codEstadoLicencia(codigo)
                .nombreEstadoLicencia(denominacion)
                .build();
    }
}
