package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Permiso;
import com.SIGER.SIGER.model.requests.PermisoRequest;
import com.SIGER.SIGER.model.responses.PermisoResponse;
import com.SIGER.SIGER.services.PermisoService;
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
public class PermisoExpert extends
    AbsBaseExpert<Permiso, PermisoService, PermisoRequest, PermisoResponse> {

  @Autowired
  PermisoService permisoService;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<PermisoResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<Permiso> permisoPage = permisoService.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        permisoPage.getTotalPages(), "/permiso");

    List<PermisoResponse> permisoResponses = converterPageToList(permisoPage.getContent());

    return new ResponseEntity(permisoResponses, HttpStatus.OK);
  }

  private List<PermisoResponse> converterPageToList(List<Permiso> permisos) {

    List<PermisoResponse> permisoResponses = new ArrayList<>();
    for (int i = 0; i < permisos.size(); i++) {
      permisoResponses.add(
          modelMapper.map(permisos.get(i), PermisoResponse.class));
    }
    return permisoResponses;
  }

  @Override
  public ResponseEntity<PermisoResponse> findById(Long id) throws Exception {
    Permiso permiso = permisoService.findById(id);
    PermisoResponse permisoResponse = modelMapper.map(permiso, PermisoResponse.class);
    return new ResponseEntity(permisoResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<PermisoResponse> save(PermisoRequest permisoRequest) throws Exception {
    if (StringUtils.isBlank(permisoRequest.getNombrePermiso())) {
      return new ResponseEntity(new Message("El nombre es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (permisoRequest.getCodigoPermiso().length() < 0) {
      return new ResponseEntity(new Message("El codigo es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }
    Permiso permiso = modelMapper.map(permisoRequest, Permiso.class);
    permisoService.save(permiso);
    PermisoResponse permisoResponse = modelMapper.map(permiso, PermisoResponse.class);
    return new ResponseEntity(permisoResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<PermisoResponse> update(Long id, PermisoRequest permisoRequest)
      throws Exception {

    if (StringUtils.isBlank(permisoRequest.getNombrePermiso())) {
      return new ResponseEntity(new Message("El nombre es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (permisoRequest.getCodigoPermiso().length() < 0) {
      return new ResponseEntity(new Message("El codigo es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }
    Permiso permiso = modelMapper.map(permisoRequest, Permiso.class);
    permisoService.update(id, permiso);
    PermisoResponse permisoResponse = modelMapper.map(permiso, PermisoResponse.class);
    return new ResponseEntity(permisoResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    return new ResponseEntity(HttpStatus.OK);
  }

}
