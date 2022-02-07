package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.TipoMovilidad;
import com.SIGER.SIGER.repositories.TipoMovilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class _0_TipoMovilidadSeeder implements CommandLineRunner {

    @Autowired
    TipoMovilidadRepository tipoMovilidadRepository;

    @Override
    public void run(String... args) throws Exception {
        loadTipoMovilidades();
    }

    private void loadTipoMovilidades() {
        if (tipoMovilidadRepository.count() == 0) {
            tipoMovilidadRepository.save(
                    buildTipoMovilidad("B1", "Automóviles, utilitarios, camionetas, vans y casas rodantes motorizadas hasta tres mil quinientos kilogramos (3500 kg)"));
            tipoMovilidadRepository.save(
                    buildTipoMovilidad("B2", "Automóviles, camionetas, vans y casas rodantes motorizadas hasta tres mil quinientos kilogramos (3500 kg) de peso con un acoplado de hasta setecientos cincuenta kilogramos (750 kg) o casa rodante no motorizada"));
            tipoMovilidadRepository.save(
                    buildTipoMovilidad("C1", "Camiones sin acoplado, ni semiacoplado, ni articulado y vehículos o casa rodante motorizada de más de tres mil quinientos kilogramos (3500 kg) de peso y hasta doce mil kilogramos (12.000 kg) de peso"));
            tipoMovilidadRepository.save(
                    buildTipoMovilidad("C2", "Camiones sin acoplado, ni semiacoplado, ni articulado y vehículos o casa rodante motorizada de más de doce mil kilogramos (12.000 kg) de peso y hasta veinticuatro mil kilogramos (24.000 kg)"));
            tipoMovilidadRepository.save(
                    buildTipoMovilidad("C3", "Camiones sin acoplado, ni semiacoplado, ni articulado y vehículos o casa rodante motorizada de más de veinticuatro mil kilogramos (24.000 kg) de peso"));
            tipoMovilidadRepository.save(
                    buildTipoMovilidad("D1", "Automotores para servicios de transporte de pasajeros hasta ocho (8) plazas, excluido el conductor"));
            tipoMovilidadRepository.save(
                    buildTipoMovilidad("D2", "Automotores para servicios de transporte de pasajeros de más de ocho (8) plazas y hasta veinte (20) plazas, excluido el conductor"));
            tipoMovilidadRepository.save(
                    buildTipoMovilidad("D3", "Automotores para servicios de transporte de pasajeros de más de veinte (20) plazas, excluido el conductor"));
            tipoMovilidadRepository.save(
                    buildTipoMovilidad("E1", "Vehículos automotores de clase C o D, según el caso, con uno o más remolques o articulaciones"));
            tipoMovilidadRepository.save(
                    buildTipoMovilidad("E2", "Maquinaria especial no agrícola"));

        }
    }

    private TipoMovilidad buildTipoMovilidad(String codigo, String denominacion) {
        return TipoMovilidad.builder()
                .fechaAlta(new Date())
                .codigo(codigo)
                .denominacion(denominacion)
                .build();
    }
}
