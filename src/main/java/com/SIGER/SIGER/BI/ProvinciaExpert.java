/*package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.direccion.Provincia;
import com.SIGER.SIGER.model.requests.ProvinciaRequest;
import com.SIGER.SIGER.model.responses.ProvinciaResponse;
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
public class ProvinciaExpert extends
    AbsBaseExpert<Provincia, ProvinciaService, ProvinciaRequest, ProvinciaResponse> {

  @Autowired
  ProvinciaService provinciaService;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<ProvinciaResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<Provincia> provinciaPage = provinciaService.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        provinciaPage.getTotalPages(), "/provincia");

    List<ProvinciaResponse> provinciaResponses = converterPageToList(provinciaPage.getContent());

    return new ResponseEntity(provinciaResponses, HttpStatus.OK);
  }

  private List<ProvinciaResponse> converterPageToList(List<Provincia> provincias) {

    List<ProvinciaResponse> provinciaResponses = new ArrayList<>();
    for (int i = 0; i < provincias.size(); i++) {
      provinciaResponses.add(
          modelMapper.map(provincias.get(i), ProvinciaResponse.class));
    }
    return provinciaResponses;
  }

  @Override
  public ResponseEntity<ProvinciaResponse> findById(Long id) throws Exception {
    Provincia provincia = provinciaService.findById(id);
    ProvinciaResponse provinciaResponse = modelMapper.map(provincia, ProvinciaResponse.class);
    return new ResponseEntity(provinciaResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ProvinciaResponse> save(ProvinciaRequest provinciaRequest)
      throws Exception {

    if (StringUtils.isBlank(provinciaRequest.getDenominacion())) {
      return new ResponseEntity(new Message("La denominacion es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }
    if (provinciaRequest.getCodigo().length() < 0) {
      return new ResponseEntity(new Message("El codigo es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }

    Provincia provincia = modelMapper.map(provinciaRequest, Provincia.class);
    provinciaService.save(provincia);
    return new ResponseEntity(response, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ProvinciaResponse> update(Long id, ProvinciaRequest provinciaRequest)
      throws Exception {
    if (provinciaService.findById(id).equals(false)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }

    if (StringUtils.isBlank(provinciaRequest.getDenominacion())) {
      return new ResponseEntity(new Message("La denominacion es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }
    if (provinciaRequest.getCodigo().length() < 0) {
      return new ResponseEntity(new Message("El codigo es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }
    Provincia provincia = modelMapper.map(provinciaRequest, Provincia.class);
    ProvinciaResponse provinciaResponse = modelMapper.map(provinciaService.save(provincia),
        ProvinciaResponse.class);
    return new ResponseEntity(provinciaResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    provinciaService.delete(id);
    return new ResponseEntity(new Message("Provincia eliminada"), HttpStatus.OK);
  }

}
*/