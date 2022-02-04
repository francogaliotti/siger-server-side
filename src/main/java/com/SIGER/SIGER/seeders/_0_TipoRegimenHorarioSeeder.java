package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.TipoRegimenHorario;
import com.SIGER.SIGER.repositories.TipoRegimenHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class _0_TipoRegimenHorarioSeeder implements CommandLineRunner {

    @Autowired
    TipoRegimenHorarioRepository tipoRegimenHorarioRepository;

    @Override
    public void run(String... args) throws Exception {
        loadTipoRegimenHorario();
    }


    private void loadTipoRegimenHorario(){
        if (tipoRegimenHorarioRepository.count() == 0) {
            tipoRegimenHorarioRepository.save(buildTipoRegimenHorario("B0", "Estandar"));
            tipoRegimenHorarioRepository.save(buildTipoRegimenHorario("B+1", "Estandar + 1"));
            tipoRegimenHorarioRepository.save(buildTipoRegimenHorario("B-1", "Estandar - 1"));

        }
    }

    private TipoRegimenHorario buildTipoRegimenHorario(String codigoTipoRegimenHorario, String denominacionTipoRegimenHorario){
        return TipoRegimenHorario.builder()
                .codigoTipoRegimenHorario(codigoTipoRegimenHorario)
                .denominacionTipoRegimenHorario(denominacionTipoRegimenHorario)
                .build();
    }

}
