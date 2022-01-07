package com.SIGER.SIGER.datos_gob_ar.controllers;

import com.SIGER.SIGER.datos_gob_ar.BI.DatosGobArExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.datos_gob_ar.responses.DepartamentoResponse;
import com.SIGER.SIGER.datos_gob_ar.responses.LocalidadResponse;
import com.SIGER.SIGER.datos_gob_ar.responses.MunicipioResponse;
import com.SIGER.SIGER.datos_gob_ar.responses.ProvinciaResponse;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/datos-gob-ar")
@CrossOrigin(origins = "http://localhost:4200")
public class DatosGobArController {

  @Autowired
  DatosGobArExpert datosGobArExpert;


  @GetMapping("/provincias")
  public ResponseEntity<List<ProvinciaResponse>> getAllProvincias(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return datosGobArExpert.findAllProvincias(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @GetMapping("/departamentos")
  public ResponseEntity<List<DepartamentoResponse>> getAllDepartamentos(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response, @RequestParam("id") Long id) throws Exception {
    return datosGobArExpert.findAllDepartamentos(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response, id);
  }

  @GetMapping("/municipios")
  public ResponseEntity<List<MunicipioResponse>> getAllMunicipios(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response, @RequestParam("id") Long id) throws Exception {
    return datosGobArExpert.findAllMunicipios(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response, id);
  }

  @GetMapping("/localidades")
  public ResponseEntity<List<LocalidadResponse>> getAllLocalidades(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response, @RequestParam("id") Long id) throws Exception {
    return datosGobArExpert.findAllLocalidades(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response, id);
  }


}

