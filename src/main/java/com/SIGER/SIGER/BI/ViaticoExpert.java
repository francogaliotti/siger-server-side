package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Viatico;
import com.SIGER.SIGER.model.requests.ViaticoRequest;
import com.SIGER.SIGER.model.responses.ViaticoResponse;
import com.SIGER.SIGER.services.ViaticoService;
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
public class ViaticoExpert extends
    AbsBaseExpert<Viatico, ViaticoService, ViaticoRequest, ViaticoResponse> {

  @Autowired
  ViaticoService viaticoServiceImpl;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<ViaticoResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<Viatico> viaticoPage = viaticoServiceImpl.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        viaticoPage.getTotalPages(), "/viatico");

    List<ViaticoResponse> viaticoResponses = converterPageToList(viaticoPage.getContent());

    return new ResponseEntity(viaticoResponses, HttpStatus.OK);
  }

  private List<ViaticoResponse> converterPageToList(List<Viatico> viaticos) {

    List<ViaticoResponse> viaticoResponses = new ArrayList<>();
    for (int i = 0; i < viaticos.size(); i++) {
      viaticoResponses.add(
          modelMapper.map(viaticos.get(i), ViaticoResponse.class));
    }
    return viaticoResponses;
  }

  @Override
  public ResponseEntity<ViaticoResponse> findById(Long id) throws Exception {
    Viatico viatico = viaticoServiceImpl.findById(id);
    ViaticoResponse viaticoResponse = modelMapper.map(viatico, ViaticoResponse.class);
    return new ResponseEntity(viaticoResponse, HttpStatus.OK);
  }

  /*@Override
  public ResponseEntity<Viatico> getByNombre(String denominacionViatico) {
    if (!viaticoServiceImpl.existByDenominacionViatico(denominacionViatico)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }
    Viatico viatico = viaticoServiceImpl.getByDenominacionViatico(denominacionViatico).get();
    return new ResponseEntity(viatico, HttpStatus.OK);
  }*/

  @Override
  public ResponseEntity<ViaticoResponse> save(ViaticoRequest viaticoRequest) throws Exception {
    if (StringUtils.isBlank(viaticoRequest.getDenominacionViatico())) {
      return new ResponseEntity(new Message("El nombre es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (viaticoRequest.getCodViatico().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (viaticoServiceImpl.existByDenominacionViatico(viaticoRequest.getDenominacionViatico())) {
      return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
    }
    if (viaticoRequest.getImporte() < 0) {
      return new ResponseEntity(new Message("El importe debe ser positivo"),
          HttpStatus.BAD_REQUEST);
    }
    Viatico viatico = Viatico.builder().codViatico(viaticoRequest.getCodViatico())
        .denominacionViatico(viaticoRequest.getDenominacionViatico())
        .importe(viaticoRequest.getImporte()).build();

    viaticoServiceImpl.save(viatico);

    return new ResponseEntity(new Message("Viatico creado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ViaticoResponse> update(Long id, ViaticoRequest viaticoRequest)
      throws Exception {

    if (StringUtils.isBlank(viaticoRequest.getDenominacionViatico())) {
      return new ResponseEntity(new Message("El nombre es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (viaticoRequest.getCodViatico().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }
    if (viaticoRequest.getImporte() < 0) {
      return new ResponseEntity(new Message("El importe debe ser positivo"),
          HttpStatus.BAD_REQUEST);
    }

    Viatico viatico = viaticoServiceImpl.findById(id);
    viatico.setCodViatico(viaticoRequest.getCodViatico());
    viatico.setDenominacionViatico(viaticoRequest.getDenominacionViatico());
    viatico.setImporte(viaticoRequest.getImporte());
    viaticoServiceImpl.update(id, viatico);

    return new ResponseEntity(new Message("Viatico actualizado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    viaticoServiceImpl.delete(id);
    return new ResponseEntity(new Message("Viatico eliminado"), HttpStatus.OK);
  }


}
