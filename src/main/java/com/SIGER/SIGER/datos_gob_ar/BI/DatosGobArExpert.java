package com.SIGER.SIGER.datos_gob_ar.BI;

import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.datos_gob_ar.entities.Departamento;
import com.SIGER.SIGER.datos_gob_ar.entities.Localidad;
import com.SIGER.SIGER.datos_gob_ar.entities.Municipio;
import com.SIGER.SIGER.datos_gob_ar.entities.Provincia;
import com.SIGER.SIGER.datos_gob_ar.responses.DepartamentoResponse;
import com.SIGER.SIGER.datos_gob_ar.responses.LocalidadResponse;
import com.SIGER.SIGER.datos_gob_ar.responses.MunicipioResponse;
import com.SIGER.SIGER.datos_gob_ar.responses.ProvinciaResponse;
import com.SIGER.SIGER.datos_gob_ar.services.DepartamentoService;
import com.SIGER.SIGER.datos_gob_ar.services.LocalidadService;
import com.SIGER.SIGER.datos_gob_ar.services.MunicipioService;
import com.SIGER.SIGER.datos_gob_ar.services.ProvinciaService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class DatosGobArExpert {

  @Autowired
  ProvinciaService provinciaService;

  @Autowired
  DepartamentoService departamentoService;

  @Autowired
  MunicipioService municipioService;

  @Autowired
  LocalidadService localidadService;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  ModelMapper modelMapper = new ModelMapper();


  public ResponseEntity<List<ProvinciaResponse>> findAllProvincias(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<Provincia> provinciaPage = provinciaService.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        provinciaPage.getTotalPages(), "/provincias");

    List<ProvinciaResponse> provinciaResponses = converterProvinciaPageToList(provinciaPage.getContent());

    return new ResponseEntity(provinciaResponses, HttpStatus.OK);
  }

  private List<ProvinciaResponse> converterProvinciaPageToList(List<Provincia> provincias) {

    List<ProvinciaResponse> provinciaResponses = new ArrayList<>();
    for (int i = 0; i < provincias.size(); i++) {
      provinciaResponses.add(
          modelMapper.map(provincias.get(i), ProvinciaResponse.class));
    }
    return provinciaResponses;
  }

  public ResponseEntity<List<DepartamentoResponse>> findAllDepartamentos(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response, Long id) throws Exception {

    Page<Departamento> departamentoPage = departamentoService.findAll(page, size, id);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        departamentoPage.getTotalPages(), "/departamentos");

    List<DepartamentoResponse> departamentoResponses = converterDepartamentoPageToList(departamentoPage.getContent());

    return new ResponseEntity(departamentoResponses, HttpStatus.OK);
  }

  private List<DepartamentoResponse> converterDepartamentoPageToList(List<Departamento> departamentos) {

    List<DepartamentoResponse> departamentoResponses = new ArrayList<>();
    for (int i = 0; i < departamentos.size(); i++) {
      departamentoResponses.add(
          modelMapper.map(departamentos.get(i), DepartamentoResponse.class));
    }
    return departamentoResponses;
  }

  public ResponseEntity<List<MunicipioResponse>> findAllMunicipios(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response, Long id) throws Exception {

    Page<Municipio> municipioPage = municipioService.findAll(page, size, id);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        municipioPage.getTotalPages(), "/municipios");

    List<MunicipioResponse> municipioResponses = converterMunicipioPageToList(municipioPage.getContent());

    return new ResponseEntity(municipioResponses, HttpStatus.OK);
  }

  private List<MunicipioResponse> converterMunicipioPageToList(List<Municipio> municipios) {

    List<MunicipioResponse> municipioResponses = new ArrayList<>();
    for (int i = 0; i < municipios.size(); i++) {
      municipioResponses.add(
          modelMapper.map(municipios.get(i), MunicipioResponse.class));
    }
    return municipioResponses;
  }

  public ResponseEntity<List<LocalidadResponse>> findAllLocalidades(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response, Long id) throws Exception {

    Page<Localidad> localidadPage = localidadService.findAll(page, size, id);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        localidadPage.getTotalPages(), "/localidades");

    List<LocalidadResponse> localidadResponses = converterLocalidadPageToList(localidadPage.getContent());

    return new ResponseEntity(localidadResponses, HttpStatus.OK);
  }

  private List<LocalidadResponse> converterLocalidadPageToList(List<Localidad> localidades) {

    List<LocalidadResponse> localidadResponses = new ArrayList<>();
    for (int i = 0; i < localidades.size(); i++) {
      localidadResponses.add(
          modelMapper.map(localidades.get(i), LocalidadResponse.class));
    }
    return localidadResponses;
  }




}
