package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Remuneracion;
import com.SIGER.SIGER.model.requests.RemuneracionRequest;
import com.SIGER.SIGER.model.responses.RemuneracionResponse;
import com.SIGER.SIGER.services.RemuneracionService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RemuneracionExpert extends
    AbsBaseExpert<Remuneracion, RemuneracionService, RemuneracionRequest, RemuneracionResponse> {

  @Autowired
  RemuneracionService remuneracionService;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<RemuneracionResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<Remuneracion> remuneracionPage = remuneracionService.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        remuneracionPage.getTotalPages(), "/remuneracion");
    List<RemuneracionResponse> remuneracionResponses = converterPageToList(
        remuneracionPage.getContent());
    return new ResponseEntity(remuneracionResponses, HttpStatus.OK);
  }

  public ResponseEntity<List<RemuneracionResponse>> findAll() throws Exception {
    List<Remuneracion> remuneracionList = remuneracionService.findAll();
    return new ResponseEntity(remuneracionList, HttpStatus.OK);
  }

  private List<RemuneracionResponse> converterPageToList(List<Remuneracion> remuneraciones) {

    List<RemuneracionResponse> remuneracionResponses = new ArrayList<>();
    for (int i = 0; i < remuneraciones.size(); i++) {
      remuneracionResponses.add(
          modelMapper.map(remuneraciones.get(i), RemuneracionResponse.class));
    }
    return remuneracionResponses;
  }

  @Override
  public ResponseEntity<RemuneracionResponse> findById(Long id) throws Exception {
    Remuneracion remuneracion = remuneracionService.findById(id);
    RemuneracionResponse remuneracionResponse = modelMapper.map(remuneracion,
        RemuneracionResponse.class);
    return new ResponseEntity(remuneracionResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<RemuneracionResponse> save(RemuneracionRequest remuneracionRequest)
      throws Exception {
    if (remuneracionRequest.getValorHora() < 0) {
      return new ResponseEntity(new Message("El Valor Hora no puede ser negativo"),
          HttpStatus.BAD_REQUEST);
    }
    if (remuneracionRequest.getValorViaticoDia() < 0) {
      return new ResponseEntity(new Message("El Valor del Viatico por Dia no puede ser negativo"),
          HttpStatus.BAD_REQUEST);
    }

    if (remuneracionRequest.getImporteHorasAdicionales() < 0) {
      return new ResponseEntity(
          new Message("El Importe de Horas Adicionales no puede ser negativo"),
          HttpStatus.BAD_REQUEST);
    }
    if (remuneracionRequest.getImporteZonaDesarraigo() < 0) {
      return new ResponseEntity(new Message("El Importe por Zona no puede ser negativo"),
          HttpStatus.BAD_REQUEST);
    }

    Remuneracion remuneracion = Remuneracion.builder()
        .valorHora(remuneracionRequest.getValorHora())
        .valorViaticoDia(remuneracionRequest.getValorViaticoDia())
        .importeHorasAdicionales(remuneracionRequest.getImporteHorasAdicionales())
        .importeZonaDesarraigo(remuneracionRequest.getImporteZonaDesarraigo()).build();

    remuneracionService.save(remuneracion);

    return new ResponseEntity(new Message("Remuneración creada"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<RemuneracionResponse> update(Long id,
      RemuneracionRequest remuneracionRequest) throws Exception {

    if (remuneracionService.findById(id).equals(false)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }

    if (remuneracionRequest.getValorHora() < 0) {
      return new ResponseEntity(new Message("El Valor Hora no puede ser negativo"),
          HttpStatus.BAD_REQUEST);
    }
    if (remuneracionRequest.getValorViaticoDia() < 0) {
      return new ResponseEntity(new Message("El Valor del Viatico por Dia no puede ser negativo"),
          HttpStatus.BAD_REQUEST);
    }

    if (remuneracionRequest.getImporteHorasAdicionales() < 0) {
      return new ResponseEntity(
          new Message("El Importe de Horas Adicionales no puede ser negativo"),
          HttpStatus.BAD_REQUEST);
    }
    if (remuneracionRequest.getImporteZonaDesarraigo() < 0) {
      return new ResponseEntity(new Message("El Importe por Zona no puede ser negativo"),
          HttpStatus.BAD_REQUEST);
    }

    Remuneracion remuneracion = Remuneracion.builder()
        .valorHora(remuneracionRequest.getValorHora())
        .valorViaticoDia(remuneracionRequest.getValorViaticoDia())
        .importeHorasAdicionales(remuneracionRequest.getImporteHorasAdicionales())
        .importeZonaDesarraigo(remuneracionRequest.getImporteZonaDesarraigo()).build();
    remuneracionService.update(id, remuneracion);

    return new ResponseEntity(new Message("Remuneración actualizada"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    remuneracionService.delete(id);
    return new ResponseEntity(new Message("Remuneración eliminada"), HttpStatus.NO_CONTENT);
  }

}
