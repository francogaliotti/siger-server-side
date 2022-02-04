package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.Remuneracion;
import com.SIGER.SIGER.repositories.RemuneracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class _0_RemuneracionSeeder implements CommandLineRunner {

    @Autowired
    RemuneracionRepository remuneracionRepository;

    @Override
    public void run(String... args) throws Exception {
        loadRemuneraciones();
    }


    private void loadRemuneraciones(){
        if (remuneracionRepository.count() == 0) {
            remuneracionRepository.save(buildRemuneracion("Base",500,100, 200, 350));
            remuneracionRepository.save(buildRemuneracion("Media", 750,250, 550, 650));
            remuneracionRepository.save(buildRemuneracion("Alta",1000,300,600,900));
            remuneracionRepository.save(buildRemuneracion("Ejecutiva",2000, 500, 1000,1500));
        }
    }

    private Remuneracion buildRemuneracion(String denominacion, double valorHora, double valorViaticoDia, double importeHorasAdicionales, double importeZonaDesarraigo){
        return Remuneracion.builder()
                .denominacion(denominacion)
                .valorHora(valorHora)
                .valorViaticoDia(valorViaticoDia)
                .importeHorasAdicionales(importeHorasAdicionales)
                .importeZonaDesarraigo(importeZonaDesarraigo)
                .build();
    }

}
