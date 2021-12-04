package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.EstadoBoleta;
import com.SIGER.SIGER.model.requests.EstadoBoletaRequest;
import com.SIGER.SIGER.model.responses.EstadoBoletaResponse;
import com.SIGER.SIGER.services.EstadoBoletaService;
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
public class EstadoBoletaExpert extends
    AbsBaseExpert<EstadoBoleta, EstadoBoletaService, EstadoBoletaRequest, EstadoBoletaResponse> {

  @Autowired
  EstadoBoletaService estadoBoletaService;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<EstadoBoletaResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<EstadoBoleta> estadoBoletaPage = estadoBoletaService.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        estadoBoletaPage.getTotalPages(), "/estado-boleta");
    List<EstadoBoletaResponse> estadoBoletaResponse = converterPageToList(
        estadoBoletaPage.getContent());
    return new ResponseEntity(estadoBoletaResponse, HttpStatus.OK);
  }

  private List<EstadoBoletaResponse> converterPageToList(List<EstadoBoleta> estadoBoletas) {

    List<EstadoBoletaResponse> estadoBoletaResponse = new ArrayList<>();
    for (int i = 0; i < estadoBoletas.size(); i++) {
      estadoBoletaResponse.add(
          modelMapper.map(estadoBoletas.get(i), EstadoBoletaResponse.class));
    }
    return estadoBoletaResponse;
  }

  @Override
  public ResponseEntity<EstadoBoletaResponse> findById(Long id) throws Exception {
    EstadoBoleta estadoBoleta = estadoBoletaService.findById(id);
    EstadoBoletaResponse estadoBoletaResponse = modelMapper.map(estadoBoleta,
        EstadoBoletaResponse.class);
    return new ResponseEntity(estadoBoletaResponse, HttpStatus.OK);
  }

  /*public ResponseEntity<EstadoBoleta> getByNombre(
      @PathVariable("nombre") String nombreEstadoBoleta) {
      if (!estadoBoletaService.existsByNombreEstadoBoleta(nombreEstadoBoleta)) {
          return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
      }
    EstadoBoleta estadoBoleta = estadoBoletaService.getByNombreEstadoBoleta(nombreEstadoBoleta)
        .get();
    return new ResponseEntity(estadoBoleta, HttpStatus.OK);
  }*/

  @Override
  public ResponseEntity<EstadoBoletaResponse> save(EstadoBoletaRequest estadoBoletaRequest)
      throws Exception {
    if (StringUtils.isBlank(estadoBoletaRequest.getNombreEstadoBoleta())) {
      return new ResponseEntity(new Message("El nombre es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (estadoBoletaRequest.getCodEstadoBoleta().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }
    if (estadoBoletaService.existsByNombreEstadoBoleta(
        estadoBoletaRequest.getNombreEstadoBoleta())) {
      return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
    }

    EstadoBoleta estadoBoleta = EstadoBoleta.builder()
        .codEstadoBoleta(estadoBoletaRequest.getCodEstadoBoleta()).
        nombreEstadoBoleta(estadoBoletaRequest.getNombreEstadoBoleta()).build();

    estadoBoletaService.save(estadoBoleta);

    return new ResponseEntity(new Message("Estado de Boleta creado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<EstadoBoletaResponse> update(Long id,
      EstadoBoletaRequest estadoBoletaRequest) throws Exception {

    if (estadoBoletaService.findById(id).equals(false)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }

    if (StringUtils.isBlank(estadoBoletaRequest.getNombreEstadoBoleta())) {
      return new ResponseEntity(new Message("El nombre es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (estadoBoletaRequest.getCodEstadoBoleta().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }

    EstadoBoleta estadoBoleta = new EstadoBoleta();
    estadoBoleta.setCodEstadoBoleta(estadoBoletaRequest.getCodEstadoBoleta());
    estadoBoleta.setNombreEstadoBoleta(estadoBoletaRequest.getNombreEstadoBoleta());
    estadoBoletaService.update(id, estadoBoleta);

    return new ResponseEntity(new Message("Estado de Boleta actualizado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    estadoBoletaService.delete(id);
    return new ResponseEntity(new Message("Estado de Boleta eliminado"), HttpStatus.NO_CONTENT);
  }
}
