package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.TipoMovilidad;
import com.SIGER.SIGER.model.requests.TipoMovilidadRequest;
import com.SIGER.SIGER.model.responses.TipoMovilidadResponse;
import com.SIGER.SIGER.services.TipoMovilidadService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class TipoMovilidadExpert extends
    AbsBaseExpert<TipoMovilidad, TipoMovilidadService, TipoMovilidadRequest, TipoMovilidadResponse> {

  @Autowired
  TipoMovilidadService tipoMovilidadService;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<TipoMovilidadResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<TipoMovilidad> tipoMovilidadPage = tipoMovilidadService.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        tipoMovilidadPage.getTotalPages(), "/tipo-movilidad");
    List<TipoMovilidadResponse> tipoMovilidadResponses = converterPageToList(
        tipoMovilidadPage.getContent());
    return new ResponseEntity(tipoMovilidadResponses, HttpStatus.OK);
  }

  private List<TipoMovilidadResponse> converterPageToList(List<TipoMovilidad> tipoMovilidades) {

    List<TipoMovilidadResponse> tipoMovilidadResponses = new ArrayList<>();
    for (int i = 0; i < tipoMovilidades.size(); i++) {
      tipoMovilidadResponses.add(
          modelMapper.map(tipoMovilidades.get(i), TipoMovilidadResponse.class));
    }
    return tipoMovilidadResponses;
  }

  @Override
  public ResponseEntity<TipoMovilidadResponse> findById(Long id) throws Exception {
    TipoMovilidad tipoMovilidad = tipoMovilidadService.findById(id);
    TipoMovilidadResponse tipoMovilidadResponse = modelMapper.map(tipoMovilidad,
        TipoMovilidadResponse.class);
    return new ResponseEntity(tipoMovilidadResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<TipoMovilidadResponse> save(TipoMovilidadRequest tipoMovilidadRequest)
      throws Exception {
    if (StringUtils.isBlank(tipoMovilidadRequest.getDenominacion())) {
      return new ResponseEntity(new Message("El nombre es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (tipoMovilidadRequest.getCodigo().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }
    if (tipoMovilidadService.existsByDenominacion(
        tipoMovilidadRequest.getDenominacion())) {
      return new ResponseEntity(new Message("La denominación ya existe"), HttpStatus.BAD_REQUEST);
    }

    TipoMovilidad tipoMovilidad = TipoMovilidad.builder()
        .fechaAlta(tipoMovilidadRequest.getFechaAlta())
        .fechaBaja(tipoMovilidadRequest.getFechaBaja())
        .codigo(tipoMovilidadRequest.getCodigo())
        .denominacion(tipoMovilidadRequest.getDenominacion()).build();

    tipoMovilidadService.save(tipoMovilidad);

    return new ResponseEntity(new Message("Tipo de Movilidad creado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<TipoMovilidadResponse> update(Long id,
      TipoMovilidadRequest tipoMovilidadRequest) throws Exception {

    if (tipoMovilidadService.findById(id).equals(false)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }

    if (StringUtils.isBlank(tipoMovilidadRequest.getDenominacion())) {
      return new ResponseEntity(new Message("El nombre es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (tipoMovilidadRequest.getCodigo().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }
    if (tipoMovilidadService.existsByDenominacion(
        tipoMovilidadRequest.getDenominacion())) {
      return new ResponseEntity(new Message("La denominación ya existe"), HttpStatus.BAD_REQUEST);
    }

    TipoMovilidad tipoMovilidad = TipoMovilidad.builder()
        .fechaAlta(tipoMovilidadRequest.getFechaAlta())
        .fechaBaja(tipoMovilidadRequest.getFechaBaja())
        .codigo(tipoMovilidadRequest.getCodigo())
        .denominacion(tipoMovilidadRequest.getDenominacion()).build();
    tipoMovilidadService.update(id, tipoMovilidad);

    return new ResponseEntity(new Message("Tipo de Movilidad actualizado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    tipoMovilidadService.delete(id);
    return new ResponseEntity(new Message("Tipo de Movilidad eliminado"), HttpStatus.NO_CONTENT);
  }

}
