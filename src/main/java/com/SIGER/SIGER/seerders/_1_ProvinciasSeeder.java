package com.SIGER.SIGER.seerders;

import com.SIGER.SIGER.model.entities.direccion.Provincia;
import com.SIGER.SIGER.repositories.ProvinciaRepository;
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
public class _1_ProvinciasSeeder implements CommandLineRunner {

  @Autowired
  ProvinciaRepository provinciaRepository;

  @Override
  public void run(String... args) throws Exception {
    loadProvincias();
  }

  private void loadProvincias() throws CsvValidationException, IOException {
    if (provinciaRepository.count() == 0) {
      provinciasSeeder();
    }
  }

  private void provinciasSeeder() throws IOException, CsvValidationException {

    File path = new File("Datos_gob_ar/provincias.csv");

    CSVReader csvReader = new CSVReader(new FileReader(path.getAbsolutePath()));

    List<Provincia> provincias = new ArrayList<>();

    String[] columna;

    while ((columna = csvReader.readNext()) != null) {

      provincias.add(Provincia.builder()
          .categoria(columna[0])
          .latitud(columna[1])
          .longitud(columna[2])
          .fuente(columna[3])
          .id(columna[4])
          .iso_id(columna[5])
          .iso_nombre(columna[6])
          .nombre(columna[7])
          .nombre_completo(columna[8]).build());

    }
    provincias.remove(0);
    Iterable<Provincia> provinciaIterable = provincias;
    provinciaRepository.saveAll(provinciaIterable);
    csvReader.close();
  }

}
