package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.Empleado;
import com.SIGER.SIGER.model.entities.Sector;
import com.SIGER.SIGER.model.entities.TipoLicencia;
import com.SIGER.SIGER.model.entities.TipoRequerimiento;
import com.SIGER.SIGER.repositories.EmpleadoRepository;
import com.SIGER.SIGER.repositories.TipoLicenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class _3_TipoLicenciaSeeder implements CommandLineRunner {

    @Autowired
    TipoLicenciaRepository tipoLicenciaRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public void run(String... args) throws Exception {
        loadTiposLicencias();
    }

    private void loadTiposLicencias() {
        if (tipoLicenciaRepository.count() == 0) {
            tipoLicenciaRepository.save(
                    buildTipoLicencia("VH5A", "Vacaciones hasta 5 años de antiguedad", true, true, 14, 14, 0, 14, "ninguna"));
            tipoLicenciaRepository.save(
                    buildTipoLicencia("VE5-10A", "Vacaciones entre 5 y 10 años de antiguedad", true, true, 21, 0, 0, 21, "ninguna"));
            tipoLicenciaRepository.save(
                    buildTipoLicencia("VE10-20A", "Vacaciones entre 10 y 20 años de antiguedad", true, true, 28, 0, 0, 28, "ninguna"));
            tipoLicenciaRepository.save(
                    buildTipoLicencia("VM20A", "Vacaciones más de 20 años de antiguedad", true, true, 35, 14, 0, 35, "ninguna"));
            tipoLicenciaRepository.save(
                    buildTipoLicencia("LE", "Licencia por enfermedad", true, true, 30, 0, 0, 14, "ninguna"));
            tipoLicenciaRepository.save(
                    buildTipoLicencia("LM", "Licencia por maternidad", true, true, 90, 0, 0, 14, "ninguna"));
            tipoLicenciaRepository.save(
                    buildTipoLicencia("LP", "Licencia por paternidad", true, true, 2, 0, 0, 14, "ninguna"));
            tipoLicenciaRepository.save(
                    buildTipoLicencia("LEX", "Licencia por examen", true, true, 10, 0, 2, 14, "ninguna"));
            tipoLicenciaRepository.save(
                    buildTipoLicencia("LFHC", "Licencia por fallecimiento de hijos, cónyuge", true, true, 3, 0, 0, 14, "ninguna"));
            tipoLicenciaRepository.save(
                    buildTipoLicencia("LFH", "Licencia por fallecimiento de hermanos", true, true, 1, 0, 0, 14, "ninguna"));
            tipoLicenciaRepository.save(
                    buildTipoLicencia("LMTR", "Licencia por matrimonio", true, true, 10, 0, 0, 14, "ninguna"));

        }
    }

    private TipoLicencia buildTipoLicencia(String codigo, String denominacion, boolean justificaPresentismo, boolean goceSueldo, int cantidadMaximaAnual, int cantidadMaximaMensual, int cantidadMaximaDiaria, int limiteRangoDias, String observaciones) {

        List<Empleado> aprobadores = new ArrayList<>();
        List<Sector> aprueban = new ArrayList<>();

        TipoLicencia tipoLicencia = TipoLicencia.builder()
                .codigo(codigo)
                .denominacion(denominacion)
                .justificaPresentismo(justificaPresentismo)
                .goceSueldo(goceSueldo)
                .cantidadMaximaAnual(cantidadMaximaAnual)
                .cantidadMaximaMensual(cantidadMaximaMensual)
                .cantidadMaximaDiaria(cantidadMaximaDiaria)
                .limiteRangoDias(limiteRangoDias)
                .observaciones(observaciones)
                .tipoRequerimiento(new TipoRequerimiento("",1,aprueban,aprobadores))
                .build();

        return tipoLicencia;
    }
}
