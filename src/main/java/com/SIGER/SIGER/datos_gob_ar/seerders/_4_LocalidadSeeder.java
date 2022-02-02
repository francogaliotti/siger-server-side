package com.SIGER.SIGER.datos_gob_ar.seerders;

import com.SIGER.SIGER.datos_gob_ar.entities.Localidad;
import com.SIGER.SIGER.datos_gob_ar.repositories.LocalidadRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class _4_LocalidadSeeder implements CommandLineRunner {

  @Autowired
  LocalidadRepository localidadRepository;

  @Override
  public void run(String... args) throws Exception {
    loadLocalidades();
  }

  private void loadLocalidades() throws CsvValidationException, IOException {
    if (localidadRepository.count() == 0) {
      localidadesSeeder();
    }
  }

  private void localidadesSeeder() throws IOException, CsvValidationException {

    File path = new File("datos_gob_ar/localidades.csv");

    CSVReader csvReader = new CSVReader(new FileReader(path.getAbsolutePath()));

    List<Localidad> localidades = new ArrayList<>();

    String[] columna;

    while ((columna = csvReader.readNext()) != null) {
      localidades.add(Localidad.builder()
          .categoria(columna[0])
          .latitud(columna[1])
          .longitud(columna[2])
          .departamento(columna[3])
          .departamentoNombre(columna[4])
          .fuente(columna[5])
          .id(columna[6])
          .localidadCensalId(columna[7])
          .localidadCensalNombre(columna[8])
          .municipio(columna[9])
          .municipioNombre(columna[10])
          .nombre(columna[11])
          .provincia(columna[12])
          .provinciaNombre(columna[13]).build());
    }

    localidades.remove(0);
    Iterable<Localidad> localidadIterable = localidades;
    localidadRepository.saveAll(localidadIterable);
    csvReader.close();
  }

}
