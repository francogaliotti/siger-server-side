package com.SIGER.SIGER.datos_gob_ar.seerders;

import com.SIGER.SIGER.datos_gob_ar.entities.Departamento;
import com.SIGER.SIGER.datos_gob_ar.repositories.DepartamentoRepository;
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
public class _2_DepartamentoSeeder implements CommandLineRunner {

  @Autowired
  DepartamentoRepository departamentoRepository;

  @Override
  public void run(String... args) throws Exception {
    loadDepartamentos();
  }

  private void loadDepartamentos() throws CsvValidationException, IOException {
    if (departamentoRepository.count() == 0) {
      departamentosSeeder();
    }
  }

  private void departamentosSeeder() throws IOException, CsvValidationException {

    File path = new File("datos_gob_ar/departamentos.csv");

    CSVReader csvReader = new CSVReader(new FileReader(path.getAbsolutePath()));

    List<Departamento> departamentos = new ArrayList<>();

    String[] columna;

    while ((columna = csvReader.readNext()) != null) {
      departamentos.add(Departamento.builder()
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

    }

    departamentos.remove(0);
    departamentoRepository.saveAll(departamentos);
    csvReader.close();
  }

}
