package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.Sector;
import com.SIGER.SIGER.model.entities.TipoSector;
import com.SIGER.SIGER.repositories.SectorRepository;
import com.SIGER.SIGER.repositories.TipoSectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class _1_SectorSeeder implements CommandLineRunner {

    @Autowired
    SectorRepository sectorRepository;

    @Autowired
    TipoSectorRepository tipoSectorRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSectores();
    }

    private void loadSectores() {
        if (sectorRepository.count() == 0) {
            sectorRepository.save(
                    buildSector("DGRL", "Direccion General", false, 's', true, true, 0,0, Long.valueOf(1), Long.valueOf(0)));
            sectorRepository.save(
                    buildSector("GSIS", "Gerencia de Sistemas", false, 's', true, true, 0,0, Long.valueOf(2), Long.valueOf(1)));
            sectorRepository.save(
                    buildSector("GFNC", "Gerencia de Finanzas", false, 's', true, true, 0,0, Long.valueOf(3), Long.valueOf(1)));
            sectorRepository.save(
                    buildSector("GRCH", "Gerencia de Recursos Humanos", false, 's', true, true, 0,0, Long.valueOf(4), Long.valueOf(1)));
            sectorRepository.save(
                    buildSector("GOPV", "Gerencia de Operativa", false, 's', true, true, 0,0, Long.valueOf(5), Long.valueOf(1)));
            sectorRepository.save(
                    buildSector("ARC", "Area de Redes y Comunicaciones", false, 's', true, true, 0,0, Long.valueOf(2), Long.valueOf(2)));
            sectorRepository.save(
                    buildSector("ARM", "Area de Reparaciones y Mantenimiento", false, 's', true, true, 0,0, Long.valueOf(2), Long.valueOf(2)));
            sectorRepository.save(
                    buildSector("ABD", "Area de Base de Datos", false, 's', true, true, 0,0, Long.valueOf(2), Long.valueOf(2)));
            sectorRepository.save(
                    buildSector("AIE", "Area de Infraestructura", false, 's', true, true, 0,0, Long.valueOf(2), Long.valueOf(2)));
            sectorRepository.save(
                    buildSector("AAD", "Area de Administracion de Sistemas", false, 's', true, true, 0,0, Long.valueOf(2), Long.valueOf(2)));
            sectorRepository.save(
                    buildSector("ACO", "Area de Contabilidad", false, 's', true, true, 0,0, Long.valueOf(3), Long.valueOf(3)));
            sectorRepository.save(
                    buildSector("ABC", "Area de Balance", false, 's', true, true, 0,0, Long.valueOf(3), Long.valueOf(3)));
            sectorRepository.save(
                    buildSector("ATR", "Area de Tesoreria", false, 's', true, true, 0,0, Long.valueOf(3), Long.valueOf(3)));
            sectorRepository.save(
                    buildSector("APR", "Area de Personal", false, 's', true, true, 0,0, Long.valueOf(4), Long.valueOf(4)));
            sectorRepository.save(
                    buildSector("ATC", "Area de Terciarizados", false, 's', true, true, 0,0, Long.valueOf(4), Long.valueOf(4)));
            sectorRepository.save(
                    buildSector("ASS", "Area de Sueldos", false, 's', true, true, 0,0, Long.valueOf(4), Long.valueOf(4)));
            sectorRepository.save(
                    buildSector("ALS", "Area de Legales", false, 's', true, true, 0,0, Long.valueOf(5), Long.valueOf(5)));
            sectorRepository.save(
                    buildSector("ACS", "Area de Compras", false, 's', true, true, 0,0, Long.valueOf(5), Long.valueOf(5)));
            sectorRepository.save(
                    buildSector("ALC", "Area de Licitaciones", false, 's', true, true, 0,0, Long.valueOf(5), Long.valueOf(5)));
        }
    }

    private Sector buildSector(String codigo, String denominacion,
                               boolean validaFueraDeHorario, char detenerCargaBoletas, boolean permiteTrabajarHorasExtras, boolean permiteTrabajarFinDeSemana, int maximoSerenoDiurno, int maximoSerenoNocturno, Long tipoSectorId, Long sectorSuperiorId) {
        Optional<Sector> optionalSector = sectorRepository.findById(sectorSuperiorId);
        Optional<TipoSector> optionalTipoSector = tipoSectorRepository.findById(tipoSectorId);
        Sector sector = Sector.builder()
                .codigo(codigo)
                .denominacion(denominacion)
                .validaFueraDeHorario(validaFueraDeHorario)
                .detenerCargaBoletas(detenerCargaBoletas)
                .permiteTrabajarHorasExtras(permiteTrabajarHorasExtras)
                .permiteTrabajarFinDeSemana(permiteTrabajarFinDeSemana)
                .maximoSerenoDiurno(maximoSerenoDiurno)
                .maximoSerenoNocturno(maximoSerenoNocturno)
                .build();
        if (optionalTipoSector.isPresent()){
            sector.setTipoSector(optionalTipoSector.get());
        }
        if (optionalSector.isPresent()){
            sector.setSectorSuperior(optionalSector.get());
        }
        return sector;
    }
}
