package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.ZonaInhospita;
import com.SIGER.SIGER.model.requests.ZonaInhospitaRequest;
import com.SIGER.SIGER.model.responses.ZonaInhospitaResponse;
import com.SIGER.SIGER.services.ZonaInhospitaService;
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
public class ZonaInhospitaExpert extends
    AbsBaseExpert<ZonaInhospita, ZonaInhospitaService, ZonaInhospitaRequest, ZonaInhospitaResponse> {

  @Autowired
  ZonaInhospitaService zonaInhospitaService;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<ZonaInhospitaResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<ZonaInhospita> zonaInhospitaPage = zonaInhospitaService.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        zonaInhospitaPage.getTotalPages(), "/zona-inhospita");

    List<ZonaInhospitaResponse> zonaInhospitaResponses = converterPageToList(
        zonaInhospitaPage.getContent());
    return new ResponseEntity(zonaInhospitaResponses, HttpStatus.OK);
  }

  private List<ZonaInhospitaResponse> converterPageToList(List<ZonaInhospita> zonaInhospitas) {

    List<ZonaInhospitaResponse> zonaInhospitaResponses = new ArrayList<>();
    for (int i = 0; i < zonaInhospitas.size(); i++) {
      zonaInhospitaResponses.add(
          modelMapper.map(zonaInhospitas.get(i), ZonaInhospitaResponse.class));
    }
    return zonaInhospitaResponses;
  }

  @Override
  public ResponseEntity<ZonaInhospitaResponse> findById(Long id) throws Exception {
    ZonaInhospita zonaInhospita = zonaInhospitaService.findById(id);
    return new ResponseEntity(zonaInhospita, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ZonaInhospitaResponse> save(ZonaInhospitaRequest zonaInhospitaRequest)
      throws Exception {
    ZonaInhospita zonaInhospita = modelMapper.map(zonaInhospitaRequest, ZonaInhospita.class);
    zonaInhospitaService.save(zonaInhospita);
    return new ResponseEntity(new Message("Zona Inhóspita creada"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ZonaInhospitaResponse> update(Long id,
      ZonaInhospitaRequest zonaInhospitaRequest) throws Exception {

    if (StringUtils.isBlank(zonaInhospitaRequest.getDenominacionZona())) {
      return new ResponseEntity(new Message("El nombre es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (zonaInhospitaRequest.getCodZona().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }

    ZonaInhospita zonaInhospita = modelMapper.map(zonaInhospitaRequest, ZonaInhospita.class);
    zonaInhospitaService.update(id, zonaInhospita);

    return new ResponseEntity(new Message("Zona Inhóspita actualizada"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    zonaInhospitaService.delete(id);
    return new ResponseEntity(new Message("Zona Inhóspita eliminada"), HttpStatus.OK);
  }
}
