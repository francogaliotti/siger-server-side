package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.TipoSector;
import com.SIGER.SIGER.repositories.TipoSectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class _0_TipoSectorSeeder implements CommandLineRunner {

    @Autowired
    TipoSectorRepository tipoSectorRepository;

    @Override
    public void run(String... args) throws Exception {
        loadTipoSectores();
    }

    private void loadTipoSectores() {
        if (tipoSectorRepository.count() == 0) {
            tipoSectorRepository.save(
                    buildTipoSector("DN", "Direccion"));
            tipoSectorRepository.save(
                    buildTipoSector("SS", "Sistemas"));
            tipoSectorRepository.save(
                    buildTipoSector("FS", "Finanzas"));
            tipoSectorRepository.save(
                    buildTipoSector("RH", "Recursos Humanos"));
            tipoSectorRepository.save(
                    buildTipoSector("OP", "Operativa"));
        }
    }

    private TipoSector buildTipoSector(String codigo, String denominacion) {
        TipoSector tipoSector = TipoSector.builder()
                .codTipoSector(codigo)
                .nombreTipoSector(denominacion)
                .build();
        return tipoSector;
    }
}
