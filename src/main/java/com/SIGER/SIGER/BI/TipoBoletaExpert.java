package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.dto.TipoBoletaDTO;
import com.SIGER.SIGER.entities.TipoBoleta;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.servicesImpl.TipoBoletaServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TipoBoletaExpert {

  @Autowired
  TipoBoletaServiceImpl tipoBoletaServiceImpl;

  public ResponseEntity<List<TipoBoleta>> getAll() {
    List<TipoBoleta> list = null;
    try {
      list = tipoBoletaServiceImpl.FindAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    ModelMapper modelMapper = new ModelMapper();
    List<TipoBoletaDTO> tipoBoletaDTOS = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      tipoBoletaDTOS.add(modelMapper.map(list.get(i), TipoBoletaDTO.class));
    }
    return new ResponseEntity(tipoBoletaDTOS, HttpStatus.OK);
  }

  public ResponseEntity<?> getOne(Long id) {
    try {
      if(tipoBoletaServiceImpl.FindById(id).equals(false))
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      e.printStackTrace();
    }
    TipoBoleta tipoBoleta = null;
    try {
      tipoBoleta = tipoBoletaServiceImpl.FindById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(tipoBoleta, HttpStatus.OK);
  }

  /*public ResponseEntity<EstadoBoleta> getByNombre(@PathVariable("nombre") String nombreEstadoBoleta){
    if(!tipoBoletaServiceImpl.existsByNombreEstadoBoleta(nombreEstadoBoleta))
      return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    EstadoBoleta estadoBoleta = tipoBoletaServiceImpl.getByNombreEstadoBoleta(nombreEstadoBoleta).get();
    return new ResponseEntity(estadoBoleta, HttpStatus.OK);
  }*/

  public ResponseEntity<?> save(TipoBoletaDTO tipoBoletaDTO) {
    System.out.println(tipoBoletaDTO.getTipoBoletaDenominacion());
    if(StringUtils.isBlank(tipoBoletaDTO.getTipoBoletaDenominacion()))
      return new ResponseEntity(new Mensaje("La denominación del tipo de Boleta es obligatoria"), HttpStatus.BAD_REQUEST);
    if(StringUtils.isBlank(tipoBoletaDTO.getTipoRequerimientoDenominacion()))
      return new ResponseEntity(new Mensaje("La denominación del tipo de Requerimiento es obligatoria"), HttpStatus.BAD_REQUEST);
    if(tipoBoletaDTO.getCodigo().length()<0)
      return new ResponseEntity(new Mensaje("El código es obligatorio"), HttpStatus.BAD_REQUEST);
    if(tipoBoletaServiceImpl.existsByTipoBoletaDenominacion(tipoBoletaDTO.getTipoBoletaDenominacion()))
      return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
    ModelMapper modelMapper = new ModelMapper();
    TipoBoleta tipoBoleta = modelMapper.map(tipoBoletaDTO, TipoBoleta.class);
    try {
      tipoBoletaServiceImpl.Save(tipoBoleta);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(new Mensaje("Tipo de Boleta creado"), HttpStatus.OK);
  }

  public ResponseEntity<?> update(Long id, TipoBoletaDTO tipoBoletaDTO) {
    try {
      if(tipoBoletaServiceImpl.FindById(id).equals(false))
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    if(StringUtils.isBlank(tipoBoletaDTO.getTipoBoletaDenominacion()))
      return new ResponseEntity(new Mensaje("La denominación del tipo de Boleta es obligatoria"), HttpStatus.BAD_REQUEST);
    if(StringUtils.isBlank(tipoBoletaDTO.getTipoRequerimientoDenominacion()))
      return new ResponseEntity(new Mensaje("La denominación del tipo de Requerimiento es obligatoria"), HttpStatus.BAD_REQUEST);
    if(tipoBoletaDTO.getCodigo().length()<0)
      return new ResponseEntity(new Mensaje("El código es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

    try {
      TipoBoleta tipoBoleta = tipoBoletaServiceImpl.FindById(id);
      tipoBoleta.setCodigo(tipoBoletaDTO.getCodigo());
      tipoBoleta.setTipoBoletaDenominacion(tipoBoletaDTO.getTipoBoletaDenominacion());
      tipoBoleta.setTieneMovilidad(tipoBoletaDTO.isTieneMovilidad());
      tipoBoleta.setTineZonaInhospita(tipoBoletaDTO.isTineZonaInhospita());
      tipoBoleta.setTieneViatico(tipoBoleta.isTieneViatico());
      tipoBoleta.setPermiteNoFichadaRetorno(tipoBoletaDTO.isPermiteNoFichadaRetorno());
      tipoBoleta.setPermiteNoFichadaSalida(tipoBoletaDTO.isPermiteNoFichadaSalida());
      tipoBoleta.getTipoRequerimiento().setTipoRequerimientoDenominacion(tipoBoletaDTO.getTipoRequerimientoDenominacion());
      tipoBoleta.getTipoRequerimiento().setCantNiveles(tipoBoletaDTO.getTipoRequerimientoCantNiveles());
      tipoBoletaServiceImpl.Update(id, tipoBoleta);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(new Mensaje("Tipo de Boleta actualizado"), HttpStatus.OK);
  }

  public ResponseEntity<?> delete(Long id) {
    try {
      if(tipoBoletaServiceImpl.FindById(id).equals(false))
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    try {
      tipoBoletaServiceImpl.Delete(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(new Mensaje("Tipo de Boleta eliminado"), HttpStatus.OK);
  }

}
