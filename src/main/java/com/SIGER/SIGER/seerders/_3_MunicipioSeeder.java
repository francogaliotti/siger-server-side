package com.SIGER.SIGER.seerders;

import com.SIGER.SIGER.model.entities.direccion.Municipio;
import com.SIGER.SIGER.repositories.MunicipioRepository;
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
public class _3_MunicipioSeeder implements CommandLineRunner {

  /*@Autowired
  ProvinciaRepository provinciaRepository;*/

  @Autowired
  MunicipioRepository municipioRepository;

  @Override
  public void run(String... args) throws Exception {
    loadMunicipios();
  }

  private void loadMunicipios() throws CsvValidationException, IOException {
    if (municipioRepository.count() == 0) {
      municipiosSeeder();
    }
  }

  private void municipiosSeeder() throws IOException, CsvValidationException {

    File path = new File("Datos_gob_ar/municipios.csv");

    CSVReader csvReader = new CSVReader(new FileReader(path.getAbsolutePath()));

    List<Municipio> municipios = new ArrayList<>();

    String[] columna;

    while ((columna = csvReader.readNext()) != null) {

      //Optional<Provincia> optionalProvincia = provinciaRepository.findById(columna[7]);

      //if (optionalProvincia.isPresent()) {
      municipios.add(Municipio.builder()
          .categoria(columna[0])
          .latitud(columna[1])
          .longitud(columna[2])
          .fuente(columna[3])
          .id(columna[4])
          .nombre(columna[5])
          .nombre_completo(columna[6])
          .provincia(columna[7])
          .provinciaInterseccion(columna[8])
          .provinciaNombre(columna[9]).build());
      //}

    }

    municipios.remove(0);
    Iterable<Municipio> municipioIterable = municipios;
    municipioRepository.saveAll(municipioIterable);
    csvReader.close();
  }

}

