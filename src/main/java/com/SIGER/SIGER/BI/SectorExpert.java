package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Sector;
import com.SIGER.SIGER.model.requests.SectorRequest;
import com.SIGER.SIGER.model.responses.SectorResponse;
import com.SIGER.SIGER.services.SectorService;
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
public class SectorExpert extends
    AbsBaseExpert<Sector, SectorService, SectorRequest, SectorResponse> {

  @Autowired
  SectorService sectorServiceImpl;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<SectorResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<Sector> sectorPage = sectorServiceImpl.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        sectorPage.getTotalPages(), "/sector");

    List<SectorResponse> sectorResponses = converterPageToList(sectorPage.getContent());

    return new ResponseEntity(sectorResponses, HttpStatus.OK);
  }

  private List<SectorResponse> converterPageToList(List<Sector> sectors) {

    List<SectorResponse> sectorResponses = new ArrayList<>();
    for (int i = 0; i < sectors.size(); i++) {
      sectorResponses.add(
          modelMapper.map(sectors.get(i), SectorResponse.class));
    }
    return sectorResponses;
  }

  @Override
  public ResponseEntity<SectorResponse> findById(Long id) throws Exception {
    Sector sector = sectorServiceImpl.findById(id);
    SectorResponse sectorResponse = modelMapper.map(sector, SectorResponse.class);
    return new ResponseEntity(sectorResponse, HttpStatus.OK);
  }

  /*public ResponseEntity<Sector> getByNombre(String denominacion){
    if(!sectorServiceImpl.existsByDenominacion(denominacion))
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    Sector sector = sectorServiceImpl.getByDenominacion(denominacion).get();
    return new ResponseEntity(sector, HttpStatus.OK);
  }*/

  @Override
  public ResponseEntity<SectorResponse> save(SectorRequest sectorRequest) throws Exception {
    if (StringUtils.isBlank(sectorRequest.getDenominacion())) {
      return new ResponseEntity(new Message("El nombre del Sector es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (sectorRequest.getCodigo().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }
    if (sectorServiceImpl.existsByDenominacion(sectorRequest.getDenominacion())) {
      return new ResponseEntity(new Message("El nombre del Sector ya existe"),
          HttpStatus.BAD_REQUEST);
    }
    Sector sector = Sector.builder().codigo(sectorRequest.getCodigo())
        .denominacion(sectorRequest.getDenominacion())
        .validaFueraDeHorario(sectorRequest.isValidaFueraDeHorario())
        .permiteTrabajarHorasExtras(sectorRequest.isPermiteTrabajarHorasExtras())
        .permiteTrabajarFinDeSemana(sectorRequest.isPermiteTrabajarFinDeSemana())
        .maximoSerenoDiurno(sectorRequest.getMaximoSerenoDiurno())
        .maximoSerenoNocturno(sectorRequest.getMaximoSerenoNocturno())
        .sectorSuperior(sectorRequest.getSectorSuperior())
        .tipoSector(sectorRequest.getTipoSector()).build();
        //.domicilio(sectorRequest.getDomicilio())


    sectorServiceImpl.save(sector);

    return new ResponseEntity(new Message("Sector creado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<SectorResponse> update(Long id, SectorRequest sectorRequest)
      throws Exception {
    try {
      if (sectorServiceImpl.findById(id).equals(false)) {
        return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
      }
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    if (StringUtils.isBlank(sectorRequest.getDenominacion())) {
      return new ResponseEntity(new Message("El nombre del Sector es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (sectorRequest.getCodigo().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }

    Sector sector = sectorServiceImpl.findById(id);
    sector.setCodigo(sectorRequest.getCodigo());
    sector.setDenominacion(sectorRequest.getDenominacion());
    sector.setValidaFueraDeHorario(sectorRequest.isValidaFueraDeHorario());
    sector.setPermiteTrabajarHorasExtras(sectorRequest.isPermiteTrabajarHorasExtras());
    sector.setPermiteTrabajarFinDeSemana(sectorRequest.isPermiteTrabajarFinDeSemana());
    sector.setMaximoSerenoDiurno(sectorRequest.getMaximoSerenoDiurno());
    sector.setMaximoSerenoNocturno(sectorRequest.getMaximoSerenoNocturno());
    sector.setSectorSuperior(sectorRequest.getSectorSuperior());
    sector.setTipoSector(sectorRequest.getTipoSector());
    //sector.setDomicilio(sectorRequest.getDomicilio());
    sectorServiceImpl.update(id, sector);

    return new ResponseEntity(new Message("Sector actualizado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {

    sectorServiceImpl.delete(id);

    return new ResponseEntity(new Message("Sector eliminado"), HttpStatus.OK);
  }

}
