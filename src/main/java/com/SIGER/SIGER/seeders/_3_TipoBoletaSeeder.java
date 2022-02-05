package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.Empleado;
import com.SIGER.SIGER.model.entities.Sector;
import com.SIGER.SIGER.model.entities.TipoBoleta;
import com.SIGER.SIGER.model.entities.TipoRequerimiento;
import com.SIGER.SIGER.repositories.EmpleadoRepository;
import com.SIGER.SIGER.repositories.TipoBoletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class _3_TipoBoletaSeeder implements CommandLineRunner {

    @Autowired
    TipoBoletaRepository tipoBoletaRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public void run(String... args) throws Exception {
        loadTiposBoletas();
    }

    private void loadTiposBoletas() {
        if (tipoBoletaRepository.count() == 0) {
            tipoBoletaRepository.save(
                    buildTipoBoleta("RP","Razones particulares",false, false, false, false,false));
            tipoBoletaRepository.save(
                    buildTipoBoleta("CxD","Comision por día",false, false, false, false,false));
            tipoBoletaRepository.save(
                    buildTipoBoleta("S","Sereno",false, false, false, false,false));
            tipoBoletaRepository.save(
                    buildTipoBoleta("VG","Viático gabinete",false, false, false, false,false));
            tipoBoletaRepository.save(
                    buildTipoBoleta("F","Franquicia",false, false, false, false,false));


        }
    }

    private TipoBoleta buildTipoBoleta(String codigo, String tipoBoletaDenominacion, boolean tieneMovilidad, boolean tieneZonaInhospita, boolean tieneViatico, boolean permiteNoFichadaRetorno, boolean permiteNoFichadaSalida) {


        List<Empleado> aprobadores = new ArrayList<>();
        List<Sector> aprueban = new ArrayList<>();

        TipoBoleta tipoBoleta = TipoBoleta.builder()
                .codigo(codigo)
                .tipoBoletaDenominacion(tipoBoletaDenominacion)
                .tieneMovilidad(tieneMovilidad)
                .tieneZonaInhospita(tieneZonaInhospita)
                .tieneViatico(tieneViatico)
                .permiteNoFichadaRetorno(permiteNoFichadaRetorno)
                .permiteNoFichadaSalida(permiteNoFichadaSalida)
                .tipoRequerimiento(new TipoRequerimiento("",1,aprueban,aprobadores))
                .build();

        return tipoBoleta;
    }

}
