package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.EstadoLicencia;
import com.SIGER.SIGER.model.requests.EstadoLicenciaRequest;
import com.SIGER.SIGER.model.responses.EstadoLicenciaResponse;
import com.SIGER.SIGER.services.EstadoLicenciaService;
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
public class EstadoLicenciaExpert extends
    AbsBaseExpert<EstadoLicencia, EstadoLicenciaService, EstadoLicenciaRequest, EstadoLicenciaResponse> {

  @Autowired
  EstadoLicenciaService estadoLicenciaService;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<EstadoLicenciaResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<EstadoLicencia> estadoLicenciaResponsePage = estadoLicenciaService.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        estadoLicenciaResponsePage.getTotalPages(), "/estado-licencia");

    List<EstadoLicenciaResponse> estadoLicenciaResponses = converterPageToList(
        estadoLicenciaResponsePage.getContent());
    return new ResponseEntity(estadoLicenciaResponses, HttpStatus.OK);
  }

  private List<EstadoLicenciaResponse> converterPageToList(List<EstadoLicencia> estadoLicencias) {

    List<EstadoLicenciaResponse> estadoLicenciaResponses = new ArrayList<>();
    for (int i = 0; i < estadoLicencias.size(); i++) {
      estadoLicenciaResponses.add(
          modelMapper.map(estadoLicencias.get(i), EstadoLicenciaResponse.class));
    }
    return estadoLicenciaResponses;
  }

  @Override
  public ResponseEntity<EstadoLicenciaResponse> findById(Long id) {
    try {
      if (estadoLicenciaService.findById(id).equals(false)) {
        return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    EstadoLicencia estadoLicencia = null;

    try {
      estadoLicencia = estadoLicenciaService.findById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(estadoLicencia, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<EstadoLicenciaResponse> save(EstadoLicenciaRequest estadoLicenciaRequest)
      throws Exception {
    if (StringUtils.isBlank(estadoLicenciaRequest.getNombreEstadoLicencia())) {
      return new ResponseEntity(new Message("El nombre es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (estadoLicenciaRequest.getCodEstadoLicencia().length() < 0) {
      return new ResponseEntity(new Message("El codigo es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }
    if (estadoLicenciaService.existsByNombreEstadoLicencia(
        estadoLicenciaRequest.getNombreEstadoLicencia())) {
      return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
    }

    EstadoLicencia estadoLicencia = modelMapper.map(estadoLicenciaRequest, EstadoLicencia.class);
    estadoLicenciaService.save(estadoLicencia);

    return new ResponseEntity(new Message("Estado de Licencia creado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<EstadoLicenciaResponse> update(Long id,
      EstadoLicenciaRequest estadoLicenciaRequest) throws Exception {

    if (estadoLicenciaService.findById(id).equals(false)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }

    if (StringUtils.isBlank(estadoLicenciaRequest.getNombreEstadoLicencia())) {
      return new ResponseEntity(new Message("El nombre es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (estadoLicenciaRequest.getCodEstadoLicencia().length() < 0) {
      return new ResponseEntity(new Message("El codigo es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }

    EstadoLicencia estadoLicencia1 = estadoLicenciaService.findById(id);
    estadoLicencia1.setCodEstadoLicencia(estadoLicenciaRequest.getCodEstadoLicencia());
    estadoLicencia1.setNombreEstadoLicencia(estadoLicenciaRequest.getNombreEstadoLicencia());
    estadoLicenciaService.update(id, estadoLicencia1);

    return new ResponseEntity(new Message("Estado de Licencia actualizado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    estadoLicenciaService.delete(id);
    return new ResponseEntity(new Message("Estado de Licencia eliminado"), HttpStatus.OK);
  }
}
