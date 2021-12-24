package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.TipoRegimenHorario;
import com.SIGER.SIGER.model.requests.TipoRegimenHorarioRequest;
import com.SIGER.SIGER.model.responses.EstadoBoletaResponse;
import com.SIGER.SIGER.model.responses.TipoRegimenHorarioResponse;
import com.SIGER.SIGER.services.TipoRegimenHorarioService;
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
public class TipoRegimenHorarioExpert extends
    AbsBaseExpert<TipoRegimenHorario, TipoRegimenHorarioService, TipoRegimenHorarioRequest, TipoRegimenHorarioResponse> {

  @Autowired
  TipoRegimenHorarioService tipoRegimenHorarioService;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<TipoRegimenHorarioResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<TipoRegimenHorario> tipoRegimenHorarioPage = tipoRegimenHorarioService.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        tipoRegimenHorarioPage.getTotalPages(), "/tipo-regimen-horario");
    List<TipoRegimenHorarioResponse> tipoRegimenHorarioResponses = converterPageToList(
        tipoRegimenHorarioPage.getContent());
    return new ResponseEntity(tipoRegimenHorarioResponses, HttpStatus.OK);
  }

  private List<TipoRegimenHorarioResponse> converterPageToList(
      List<TipoRegimenHorario> tipoRegimenHorarios) {

    List<TipoRegimenHorarioResponse> tipoRegimenHorarioResponses = new ArrayList<>();
    for (int i = 0; i < tipoRegimenHorarios.size(); i++) {
      tipoRegimenHorarioResponses.add(
          modelMapper.map(tipoRegimenHorarios.get(i), TipoRegimenHorarioResponse.class));
    }
    return tipoRegimenHorarioResponses;
  }

  @Override
  public ResponseEntity<TipoRegimenHorarioResponse> findById(Long id) throws Exception {
    TipoRegimenHorario tipoRegimenHorario = tipoRegimenHorarioService.findById(id);
    EstadoBoletaResponse estadoBoletaResponse = modelMapper.map(tipoRegimenHorario,
        EstadoBoletaResponse.class);
    return new ResponseEntity(estadoBoletaResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<TipoRegimenHorarioResponse> save(
      TipoRegimenHorarioRequest tipoRegimenHorarioRequest)
      throws Exception {
    if (StringUtils.isBlank(tipoRegimenHorarioRequest.getDenominacionTipoRegimenHorario())) {
      return new ResponseEntity(new Message("La denominación es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }
    if (tipoRegimenHorarioRequest.getCodigoTipoRegimenHorario().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }
    if (tipoRegimenHorarioService.existsByDenominacionTipoRegimenHorario(
        tipoRegimenHorarioRequest.getDenominacionTipoRegimenHorario())) {
      return new ResponseEntity(new Message("La denominación ya existe"), HttpStatus.BAD_REQUEST);
    }

    TipoRegimenHorario tipoRegimenHorario = TipoRegimenHorario.builder()
        .codigoTipoRegimenHorario(tipoRegimenHorarioRequest.getCodigoTipoRegimenHorario())
        .denominacionTipoRegimenHorario(
            tipoRegimenHorarioRequest.getDenominacionTipoRegimenHorario()).build();

    tipoRegimenHorarioService.save(tipoRegimenHorario);

    return new ResponseEntity(new Message("Tipo de Regimen Horario creado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<TipoRegimenHorarioResponse> update(Long id,
      TipoRegimenHorarioRequest tipoRegimenHorarioRequest) throws Exception {

    if (tipoRegimenHorarioService.findById(id).equals(false)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }

    if (StringUtils.isBlank(tipoRegimenHorarioRequest.getDenominacionTipoRegimenHorario())) {
      return new ResponseEntity(new Message("La denominación es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }
    if (tipoRegimenHorarioRequest.getCodigoTipoRegimenHorario().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }
    if (tipoRegimenHorarioService.existsByDenominacionTipoRegimenHorario(
        tipoRegimenHorarioRequest.getDenominacionTipoRegimenHorario())) {
      return new ResponseEntity(new Message("La denominación ya existe"), HttpStatus.BAD_REQUEST);
    }

    TipoRegimenHorario tipoRegimenHorario = TipoRegimenHorario.builder()
        .codigoTipoRegimenHorario(tipoRegimenHorarioRequest.getCodigoTipoRegimenHorario())
        .denominacionTipoRegimenHorario(
            tipoRegimenHorarioRequest.getDenominacionTipoRegimenHorario()).build();

    return new ResponseEntity(new Message("Tipo de Regimen Horario actualizado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    tipoRegimenHorarioService.delete(id);
    return new ResponseEntity(new Message("Tipo de Regimen Horario eliminado"),
        HttpStatus.NO_CONTENT);
  }

}
