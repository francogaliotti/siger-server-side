package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Movilidad;
import com.SIGER.SIGER.model.requests.MovilidadRequest;
import com.SIGER.SIGER.model.responses.MovilidadResponse;
import com.SIGER.SIGER.services.MovilidadService;
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
public class MovilidadExpert extends
    AbsBaseExpert<Movilidad, MovilidadService, MovilidadRequest, MovilidadResponse> {

  @Autowired
  MovilidadService movilidadService;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<MovilidadResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<Movilidad> movilidadPage = movilidadService.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        movilidadPage.getTotalPages(), "/movilidad");
    List<MovilidadResponse> tipoRegimenHorarioResponses = converterPageToList(
        movilidadPage.getContent());
    return new ResponseEntity(tipoRegimenHorarioResponses, HttpStatus.OK);
  }

  private List<MovilidadResponse> converterPageToList(
      List<Movilidad> movilidades) {

    List<MovilidadResponse> tipoRegimenHorarioResponses = new ArrayList<>();
    for (int i = 0; i < movilidades.size(); i++) {
      tipoRegimenHorarioResponses.add(
          modelMapper.map(movilidades.get(i), MovilidadResponse.class));
    }
    return tipoRegimenHorarioResponses;
  }

  @Override
  public ResponseEntity<MovilidadResponse> findById(Long id) throws Exception {
    Movilidad movilidad = movilidadService.findById(id);
    MovilidadResponse movilidadResponse = modelMapper.map(movilidad,
        MovilidadResponse.class);
    return new ResponseEntity(movilidadResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<MovilidadResponse> save(
      MovilidadRequest movilidadRequest)
      throws Exception {
    if (StringUtils.isBlank(movilidadRequest.getPatente())) {
      return new ResponseEntity(new Message("La patente es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }
    if (movilidadRequest.getCodigo().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }
    if (movilidadService.existsByPatente(
        movilidadRequest.getPatente())) {
      return new ResponseEntity(new Message("La denominación ya existe"), HttpStatus.BAD_REQUEST);
    }

    Movilidad movilidad = Movilidad.builder()
        .fechaAlta(movilidadRequest.getFechaAlta())
        .codigo(movilidadRequest.getCodigo())
        .patente(movilidadRequest.getPatente())
        .tipoMovilidad(movilidadRequest.getTipoMovilidad()).build();
    movilidadService.save(movilidad);

    return new ResponseEntity(new Message("Movilidad creada"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<MovilidadResponse> update(Long id,
      MovilidadRequest movilidadRequest) throws Exception {

    if (movilidadService.findById(id).equals(false)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }

    if (StringUtils.isBlank(movilidadRequest.getPatente())) {
      return new ResponseEntity(new Message("La patente es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }
    if (movilidadRequest.getCodigo().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }


    Movilidad movilidad = movilidadService.findById(id);
    movilidad.setPatente(movilidadRequest.getPatente());
    movilidad.setCodigo(movilidadRequest.getCodigo());
    movilidad.setTipoMovilidad(movilidadRequest.getTipoMovilidad());
    movilidadService.update(id,movilidad);

    return new ResponseEntity(new Message("Movilidad actualizada"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    movilidadService.delete(id);
    return new ResponseEntity(new Message("Movilidad eliminada"),
        HttpStatus.NO_CONTENT);
  }

}
