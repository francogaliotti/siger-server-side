package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.Nacionalidad;
import com.SIGER.SIGER.repositories.NacionalidadRepository;
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
public class NacionalidadSeeder  implements CommandLineRunner {

  @Autowired
  NacionalidadRepository nacionalidadRepository;

  @Override
  public void run(String... args) throws Exception {
    if (nacionalidadRepository.count() == 0) {
      nacionalidadSeeder();
    }
  }

  private void nacionalidadSeeder() throws IOException, CsvValidationException {

    File path = new File("Datos_gob_ar/nacionalidad.csv");

    CSVReader csvReader = new CSVReader(new FileReader(path.getAbsolutePath()));

    List<Nacionalidad> nacionalidades = new ArrayList<>();

    String[] columna;

    while ((columna = csvReader.readNext()) != null) {
      nacionalidades.add(Nacionalidad.builder()
          .pais_nac(columna[0])
          .nombre(columna[1])
          .iso_nac(columna[2]).build());

    }
    nacionalidades.remove(0);
    Iterable<Nacionalidad> nacionalidadIterable = nacionalidades;
    nacionalidadRepository.saveAll(nacionalidadIterable);
    csvReader.close();
  }

}
