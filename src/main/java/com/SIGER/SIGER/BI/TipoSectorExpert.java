package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.TipoSector;
import com.SIGER.SIGER.model.requests.TipoSectorRequest;
import com.SIGER.SIGER.model.responses.TipoSectorResponse;
import com.SIGER.SIGER.services.TipoSectorService;
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
public class TipoSectorExpert extends
    AbsBaseExpert<TipoSector, TipoSectorService, TipoSectorRequest, TipoSectorResponse> {

  @Autowired
  TipoSectorService tipoSectorServiceImpl;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<TipoSectorResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<TipoSector> tipoSectorPage = tipoSectorServiceImpl.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        tipoSectorPage.getTotalPages(), "/tipo-sector");

    List<TipoSectorResponse> tipoSectorResponses = converterPageToList(tipoSectorPage.getContent());
    return new ResponseEntity(tipoSectorResponses, HttpStatus.OK);
  }

  private List<TipoSectorResponse> converterPageToList(List<TipoSector> tipoSectors) {

    List<TipoSectorResponse> tipoSectorResponses = new ArrayList<>();
    for (int i = 0; i < tipoSectors.size(); i++) {
      tipoSectorResponses.add(
          modelMapper.map(tipoSectors.get(i), TipoSectorResponse.class));
    }
    return tipoSectorResponses;
  }

  @Override
  public ResponseEntity<TipoSectorResponse> findById(Long id) throws Exception {
    TipoSector tipoSector = tipoSectorServiceImpl.findById(id);
    TipoSectorResponse tipoSectorResponse = modelMapper.map(tipoSector, TipoSectorResponse.class);
    return new ResponseEntity(tipoSectorResponse, HttpStatus.OK);
  }

  /*public ResponseEntity<TipoSector> getByNombreTipoSector(String nombreTipoSector){
    if(!tipoSectorServiceImpl.existsByNombreTipoSector(nombreTipoSector))
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    TipoSector tipoSector = tipoSectorServiceImpl.getByNombreTipoSector(nombreTipoSector).get();
    return new ResponseEntity(tipoSector, HttpStatus.OK);
  }*/

  @Override
  public ResponseEntity<TipoSectorResponse> save(TipoSectorRequest tipoSectorRequest)
      throws Exception {
    if (StringUtils.isBlank(tipoSectorRequest.getNombreTipoSector())) {
      return new ResponseEntity(new Message("El nombre del Tipo del Sector es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (tipoSectorServiceImpl.existsByCodTipoSector(tipoSectorRequest.getCodTipoSector())) {
      return new ResponseEntity(new Message("El código del Tipo del Sector ya existe"),
          HttpStatus.BAD_REQUEST);
    }
    if (tipoSectorServiceImpl.existsByNombreTipoSector(tipoSectorRequest.getNombreTipoSector())) {
      return new ResponseEntity(new Message("El nombre del Tipo del Sector ya existe"),
          HttpStatus.BAD_REQUEST);
    }
    TipoSector tipoSector = TipoSector.builder()
        .codTipoSector(tipoSectorRequest.getCodTipoSector())
        .nombreTipoSector(tipoSectorRequest.getNombreTipoSector())
        .build();

    tipoSectorServiceImpl.save(tipoSector);

    return new ResponseEntity(new Message("Tipo de Sector creado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<TipoSectorResponse> update(Long id, TipoSectorRequest tipoSectorRequest)
      throws Exception {

    if (tipoSectorServiceImpl.findById(id).equals(false)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }

    if (StringUtils.isBlank(tipoSectorRequest.getNombreTipoSector())) {
      return new ResponseEntity(new Message("El nombre del Tipo del Sector es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (tipoSectorServiceImpl.existsByCodTipoSector(tipoSectorRequest.getCodTipoSector())) {
      return new ResponseEntity(new Message("El código del Tipo del Sector ya existe"),
          HttpStatus.BAD_REQUEST);
    }

    TipoSector tipoSector1 = tipoSectorServiceImpl.findById(id);

    tipoSector1.setCodTipoSector(tipoSectorRequest.getCodTipoSector());
    tipoSector1.setNombreTipoSector(tipoSectorRequest.getNombreTipoSector());

    tipoSectorServiceImpl.update(id, tipoSector1);

    return new ResponseEntity(new Message("Tipo de Sector actualizado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    tipoSectorServiceImpl.delete(id);
    return new ResponseEntity(new Message("Tipo de Sector eliminado"), HttpStatus.OK);
  }

}
