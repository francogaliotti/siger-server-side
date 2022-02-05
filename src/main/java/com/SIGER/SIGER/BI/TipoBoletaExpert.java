package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.TipoBoleta;
import com.SIGER.SIGER.model.requests.TipoBoletaRequest;
import com.SIGER.SIGER.model.responses.TipoBoletaResponse;
import com.SIGER.SIGER.services.TipoBoletaService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class TipoBoletaExpert extends
    AbsBaseExpert<TipoBoleta, TipoBoletaService, TipoBoletaRequest, TipoBoletaResponse> {

  @Autowired
  TipoBoletaService tipoBoletaServiceImpl;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<TipoBoletaResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<TipoBoleta> tipoBoletaPage = tipoBoletaServiceImpl.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        tipoBoletaPage.getTotalPages(), "/tipo-boleta");

    List<TipoBoletaResponse> tipoBoletaResponses = converterPageToList(tipoBoletaPage.getContent());

    return new ResponseEntity(tipoBoletaResponses, HttpStatus.OK);
  }

  private List<TipoBoletaResponse> converterPageToList(List<TipoBoleta> tipoBoletas) {

    List<TipoBoletaResponse> tipoBoletaResponses = new ArrayList<>();
    for (int i = 0; i < tipoBoletas.size(); i++) {
      tipoBoletaResponses.add(
          modelMapper.map(tipoBoletas.get(i), TipoBoletaResponse.class));
    }
    return tipoBoletaResponses;
  }

  @Override
  public ResponseEntity<TipoBoletaResponse> findById(Long id) throws Exception {
    TipoBoleta tipoBoleta = tipoBoletaServiceImpl.findById(id);
    TipoBoletaResponse tipoBoletaResponse = modelMapper.map(tipoBoleta, TipoBoletaResponse.class);
    return new ResponseEntity(tipoBoletaResponse, HttpStatus.OK);
  }

  /*public ResponseEntity<TipoBoleta> getByNombre(String tipoBoletaDenominacion){
    if(!tipoBoletaServiceImpl.existsByTipoBoletaDenominacion(tipoBoletaDenominacion))
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    TipoBoleta tipoBoleta = tipoBoletaServiceImpl.getByTipoBoletaDenominacion(tipoBoletaDenominacion).get();
    return new ResponseEntity(tipoBoleta, HttpStatus.OK);
  }*/

  @Override
  public ResponseEntity<TipoBoletaResponse> save(TipoBoletaRequest tipoBoletaRequest)
      throws Exception {
    System.out.println(tipoBoletaRequest.getTipoBoletaDenominacion());
    if (StringUtils.isBlank(tipoBoletaRequest.getTipoBoletaDenominacion())) {
      return new ResponseEntity(new Message("La denominación del tipo de Boleta es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }
    if (tipoBoletaRequest.getCodigo().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio"), HttpStatus.BAD_REQUEST);
    }
    if (tipoBoletaServiceImpl.existsByCodigo(tipoBoletaRequest.getCodigo())) {
      return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
    }
    if (tipoBoletaServiceImpl.existsByTipoBoletaDenominacion(
        tipoBoletaRequest.getTipoBoletaDenominacion())) {
      return new ResponseEntity(new Message("El nombre ya existe"), HttpStatus.BAD_REQUEST);
    }
    ModelMapper modelMapper = new ModelMapper();
    TipoBoleta tipoBoleta = modelMapper.map(tipoBoletaRequest, TipoBoleta.class);

    tipoBoletaServiceImpl.save(tipoBoleta);

    return new ResponseEntity(new Message("Tipo de Boleta creado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<TipoBoletaResponse> update(Long id, TipoBoletaRequest tipoBoletaRequest)
      throws Exception {

    if (tipoBoletaServiceImpl.findById(id).equals(false)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }

    if (StringUtils.isBlank(tipoBoletaRequest.getTipoBoletaDenominacion())) {
      return new ResponseEntity(new Message("La denominación del tipo de Boleta es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }
    if (tipoBoletaRequest.getCodigo().length() < 0) {
      return new ResponseEntity(new Message("El código es obligatorio, o debe ser mayor a 0"),
          HttpStatus.BAD_REQUEST);
    }
try {
  TipoBoleta tipoBoleta = tipoBoletaServiceImpl.findById(id);
  tipoBoleta.setCodigo(tipoBoletaRequest.getCodigo());
  tipoBoleta.setTipoBoletaDenominacion(tipoBoletaRequest.getTipoBoletaDenominacion());
  tipoBoleta.setTieneMovilidad(tipoBoletaRequest.isTieneMovilidad());
  tipoBoleta.setTieneZonaInhospita(tipoBoletaRequest.isTieneZonaInhospita());
  tipoBoleta.setTieneViatico(tipoBoleta.isTieneViatico());
  tipoBoleta.setPermiteNoFichadaRetorno(tipoBoletaRequest.isPermiteNoFichadaRetorno());
  tipoBoleta.setPermiteNoFichadaSalida(tipoBoletaRequest.isPermiteNoFichadaSalida());
  tipoBoleta.getTipoRequerimiento()
          .setTipoRequerimientoDenominacion(tipoBoletaRequest.getTipoRequerimientoDenominacion());
  tipoBoleta.getTipoRequerimiento()
          .setCantNiveles(tipoBoletaRequest.getTipoRequerimientoCantNiveles());
  tipoBoleta.getTipoRequerimiento()
          .setAprobadores(tipoBoletaRequest.getTipoRequerimientoAprobadores());
  tipoBoleta.getTipoRequerimiento()
          .setAprueban(tipoBoletaRequest.getTipoRequerimientoAprueban());
  tipoBoletaServiceImpl.update(id, tipoBoleta);
}catch(Exception e){
  System.out.println("El problema es "+e);
}
    return new ResponseEntity(new Message("Tipo de Boleta actualizado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    tipoBoletaServiceImpl.delete(id);
    return new ResponseEntity(new Message("Tipo de Boleta eliminado"), HttpStatus.OK);
  }

}
