package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.Movilidad;
import com.SIGER.SIGER.model.entities.TipoMovilidad;
import com.SIGER.SIGER.repositories.MovilidadRepository;
import com.SIGER.SIGER.repositories.TipoMovilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class _1_MovilidadSeeder implements CommandLineRunner {

    @Autowired
    MovilidadRepository movilidadRepository;

    @Autowired
    TipoMovilidadRepository tipoMovilidadRepository;

    @Override
    public void run(String... args) throws Exception {
        loadMovilidades();
    }

    private void loadMovilidades() {
        if (movilidadRepository.count() == 0) {
            movilidadRepository.save(
                    buildMovilidad("B1_01", "AE853BC",Long.valueOf(1)));
            movilidadRepository.save(
                    buildMovilidad("B2_01", "AE102SA",Long.valueOf(2)));
            movilidadRepository.save(
                    buildMovilidad("C1_01", "AA485QH",Long.valueOf(3)));
            movilidadRepository.save(
                    buildMovilidad("C2_01", "AA146SD",Long.valueOf(4)));
            movilidadRepository.save(
                    buildMovilidad("C3_01", "AA154YJ",Long.valueOf(5)));
            movilidadRepository.save(
                    buildMovilidad("D1_01", "AD649VM",Long.valueOf(6)));
            movilidadRepository.save(
                    buildMovilidad("D2_01", "AD858MZ",Long.valueOf(7)));
            movilidadRepository.save(
                    buildMovilidad("D3_01", "AD367PZ",Long.valueOf(8)));
            movilidadRepository.save(
                    buildMovilidad("E1_01", "AB358HL",Long.valueOf(9)));
            movilidadRepository.save(
                    buildMovilidad("E2_01", "AB211YA",Long.valueOf(10)));

        }
    }

    private Movilidad buildMovilidad(String codigo, String patente, Long tipoMovilidadId) {
        Optional<TipoMovilidad> optionalTipoMovilidad = tipoMovilidadRepository.findById(tipoMovilidadId);
        Movilidad movilidad = Movilidad.builder()
                .fechaAlta(new Date())
                .codigo(codigo)
                .patente(patente)
                .build();
        if (optionalTipoMovilidad.isPresent()){
            movilidad.setTipoMovilidad(optionalTipoMovilidad.get());
        }
        return movilidad;
    }

}
