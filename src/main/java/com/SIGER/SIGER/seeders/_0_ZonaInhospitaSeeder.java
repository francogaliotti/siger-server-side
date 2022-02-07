package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.ZonaInhospita;
import com.SIGER.SIGER.repositories.ZonaInhospitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class _0_ZonaInhospitaSeeder implements CommandLineRunner {

    @Autowired
    ZonaInhospitaRepository zonaInhospitaRepository;

    @Override
    public void run(String... args) throws Exception {
        loadZonaInhospita();
    }


    private void loadZonaInhospita(){
        if (zonaInhospitaRepository.count() == 0) {
            zonaInhospitaRepository.save(buildZonaInhospita("ZI01", "Potrerillos",1000));
            zonaInhospitaRepository.save(buildZonaInhospita("ZI02", "Uspallata",2000));
            zonaInhospitaRepository.save(buildZonaInhospita("ZI03", "Costa de Araujo",1500));
            zonaInhospitaRepository.save(buildZonaInhospita("ZI01", "Malargüe",3000));
            zonaInhospitaRepository.save(buildZonaInhospita("ZI02", "Desaguadero",2500));
            zonaInhospitaRepository.save(buildZonaInhospita("ZI03", "Las Catitas",1700));
        }
    }

    private ZonaInhospita buildZonaInhospita(String codZona, String denominacion, float precio){
        return ZonaInhospita.builder()
                .codZona(codZona)
                .denominacionZona(denominacion)
                .precio(precio)
                .build();
    }

}
