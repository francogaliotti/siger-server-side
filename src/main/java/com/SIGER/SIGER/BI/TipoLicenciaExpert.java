package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.TipoLicencia;
import com.SIGER.SIGER.model.requests.TipoLicenciaRequest;
import com.SIGER.SIGER.model.responses.TipoLicenciaResponse;
import com.SIGER.SIGER.services.TipoLicenciaService;
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
public class TipoLicenciaExpert extends
        AbsBaseExpert<TipoLicencia, TipoLicenciaService, TipoLicenciaRequest, TipoLicenciaResponse> {

  @Autowired
  TipoLicenciaService tipoLicenciaServiceImpl;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<TipoLicenciaResponse>> findAll(int page, int size,
                                                            UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<TipoLicencia> tipoLicenciaPage = tipoLicenciaServiceImpl.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
            tipoLicenciaPage.getTotalPages(), "/tipo-licencia");

    List<TipoLicenciaResponse> tipoLicenciaResponses = converterPageToList(
            tipoLicenciaPage.getContent());
    return new ResponseEntity(tipoLicenciaResponses, HttpStatus.OK);
  }

  private List<TipoLicenciaResponse> converterPageToList(List<TipoLicencia> tipoLicencias) {

    List<TipoLicenciaResponse> tipoLicenciaResponses = new ArrayList<>();
    for (int i = 0; i < tipoLicencias.size(); i++) {
      tipoLicenciaResponses.add(
              modelMapper.map(tipoLicencias.get(i), TipoLicenciaResponse.class));
    }
    return tipoLicenciaResponses;
  }

  @Override
  public ResponseEntity<TipoLicenciaResponse> findById(Long id) throws Exception {
    TipoLicencia tipoLicencia = tipoLicenciaServiceImpl.findById(id);
    TipoLicenciaResponse tipoLicenciaResponse = modelMapper.map(tipoLicencia,
            TipoLicenciaResponse.class);
    return new ResponseEntity(tipoLicenciaResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<TipoLicenciaResponse> save(TipoLicenciaRequest tipoLicenciaRequest)
          throws Exception {
    if (StringUtils.isBlank(tipoLicenciaRequest.getDenominacion())) {
      return new ResponseEntity(new Message("El nombre es obligatorio"),
              HttpStatus.BAD_REQUEST);
    }
    if (tipoLicenciaRequest.getCodigo().length() < 0) {
      return new ResponseEntity(new Message("El codigo es obligatorio, o debe ser mayor a 0"),
              HttpStatus.BAD_REQUEST);
    }
        /*if(StringUtils.isBlank(tipoLicenciaDTO.getTipoRequerimientoDenominacion()))
            return new ResponseEntity(new Message("La denominación del tipo de Requerimiento es obligatoria"), HttpStatus.BAD_REQUEST);*/
    if (tipoLicenciaServiceImpl.existsByNombreTipoLicencia(tipoLicenciaRequest.getDenominacion())) {
      return new ResponseEntity(new Message("El nombre del tipo ya existe"),
              HttpStatus.BAD_REQUEST);
    }

    TipoLicencia tipoLicencia = modelMapper.map(tipoLicenciaRequest, TipoLicencia.class);

    tipoLicenciaServiceImpl.save(tipoLicencia);

    return new ResponseEntity(new Message("Tipo de licencia creado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<TipoLicenciaResponse> update(Long id,
                                                     TipoLicenciaRequest tipoLicenciaRequest)
          throws Exception {

    if (tipoLicenciaServiceImpl.findById(id).equals(false)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }

    if (StringUtils.isBlank(tipoLicenciaRequest.getDenominacion())) {
      return new ResponseEntity(new Message("El nombre es obligatorio"),
              HttpStatus.BAD_REQUEST);
    }
    if (tipoLicenciaRequest.getCodigo().length() < 0) {
      return new ResponseEntity(new Message("El codigo es obligatorio, o debe ser mayor a 0"),
              HttpStatus.BAD_REQUEST);
    }
        /*if(StringUtils.isBlank(tipoLicenciaDTO.getTipoRequerimientoDenominacion()))
            return new ResponseEntity(new Message("La denominación del tipo de Requerimiento es obligatoria"), HttpStatus.BAD_REQUEST);*/
        /*ModelMapper modelMapper = new ModelMapper();
        TipoLicencia tipoLicencia = modelMapper.map(tipoLicenciaDTO,TipoLicencia.class);*/

    TipoLicencia tipoLicencia = tipoLicenciaServiceImpl.findById(id);
    //tipoLicencia.setCantidadMaximaAnual(tipoLicenciaRequest.getCantidadMaximaAnual());
    //tipoLicencia.setCantidadMaximaMensual(tipoLicenciaRequest.getCantidadMaximaMensual());
    //tipoLicencia.setCantidadMaximaDiaria(tipoLicenciaRequest.getCantidadMaximaDiaria());
    tipoLicencia.setCodigo(tipoLicenciaRequest.getCodigo());
    tipoLicencia.setDenominacion(tipoLicenciaRequest.getDenominacion());
    tipoLicencia.setJustificaPresentismo(tipoLicenciaRequest.isJustificaPresentismo());
    tipoLicencia.setLimiteRangoDias(tipoLicenciaRequest.getLimiteRangoDias());
    tipoLicencia.setObservaciones(tipoLicenciaRequest.getObservaciones());
    tipoLicencia.getTipoRequerimiento()
            .setTipoRequerimientoDenominacion(tipoLicenciaRequest.getTipoRequerimientoDenominacion());
    tipoLicencia.getTipoRequerimiento()
            .setCantNiveles(tipoLicenciaRequest.getTipoRequerimientoCantNiveles());
    tipoLicencia.getTipoRequerimiento()
            .setAprobadores(tipoLicenciaRequest.getTipoRequerimientoAprobadores());
    tipoLicencia.getTipoRequerimiento()
            .setAprueban(tipoLicenciaRequest.getTipoRequerimientoAprueban());
    tipoLicenciaServiceImpl.update(id, tipoLicencia);

    return new ResponseEntity(new Message("Tipo de Licencia actualizado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    tipoLicenciaServiceImpl.delete(id);
    return new ResponseEntity(new Message("Tipo Licencia eliminado"), HttpStatus.OK);
  }
}
