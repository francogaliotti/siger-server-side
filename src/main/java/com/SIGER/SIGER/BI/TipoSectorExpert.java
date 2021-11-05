package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.entities.TipoSector;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.servicesImpl.TipoSectorServiceImpl;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TipoSectorExpert {

  @Autowired
  TipoSectorServiceImpl tipoSectorServiceImpl;

  public ResponseEntity<List<TipoSector>> getAll() {
    List<TipoSector> tipoSectores = null;
    try {
      tipoSectores = tipoSectorServiceImpl.FindAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(tipoSectores, HttpStatus.OK);
  }

  public ResponseEntity<?> getOne(Long id) {
    try {
      if(tipoSectorServiceImpl.FindById(id).equals(false))
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      e.printStackTrace();
    }
    TipoSector tipoSector = null;
    try {
      tipoSector = tipoSectorServiceImpl.FindById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(tipoSector, HttpStatus.OK);
  }

  /*public ResponseEntity<TipoSector> getByNombreTipoSector(String nombreTipoSector){
    if(!tipoSectorServiceImpl.existsByNombreTipoSector(nombreTipoSector))
      return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    TipoSector tipoSector = tipoSectorServiceImpl.getByNombreTipoSector(nombreTipoSector).get();
    return new ResponseEntity(tipoSector, HttpStatus.OK);
  }*/

  public ResponseEntity<?> save(TipoSector tipoSector) {
    if(StringUtils.isBlank(tipoSector.getNombreTipoSector()))
      return new ResponseEntity(new Mensaje("El nombre del Tipo del Sector es obligatorio"), HttpStatus.BAD_REQUEST);
    if(tipoSectorServiceImpl.existsByCodTipoSector(tipoSector.getCodTipoSector()))
      return new ResponseEntity(new Mensaje("El código del Tipo del Sector ya existe"), HttpStatus.BAD_REQUEST);
    if(tipoSectorServiceImpl.existsByNombreTipoSector(tipoSector.getNombreTipoSector()))
      return new ResponseEntity(new Mensaje("El nombre del Tipo del Sector ya existe"), HttpStatus.BAD_REQUEST);
    TipoSector tipoSector1 = TipoSector.builder()
        .codTipoSector(tipoSector.getCodTipoSector())
        .nombreTipoSector(tipoSector.getNombreTipoSector())
        .build();
    try {
      tipoSectorServiceImpl.Save(tipoSector1);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(new Mensaje("Tipo de Sector creado"), HttpStatus.OK);
  }

  public ResponseEntity<?> update(Long id, TipoSector tipoSector) {
    try {
      if(tipoSectorServiceImpl.FindById(id).equals(false))
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    if(StringUtils.isBlank(tipoSector.getNombreTipoSector()))
      return new ResponseEntity(new Mensaje("El nombre del Tipo del Sector es obligatorio"), HttpStatus.BAD_REQUEST);
    if(tipoSectorServiceImpl.existsByCodTipoSector(tipoSector.getCodTipoSector()))
      return new ResponseEntity(new Mensaje("El código del Tipo del Sector ya existe"), HttpStatus.BAD_REQUEST);

    try {
      TipoSector tipoSector1 = tipoSectorServiceImpl.FindById(id);

      tipoSector1.setCodTipoSector(tipoSector.getCodTipoSector());
      tipoSector1.setNombreTipoSector(tipoSector.getNombreTipoSector());

      tipoSectorServiceImpl.Update(id, tipoSector1);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(new Mensaje("Tipo de Sector actualizado"), HttpStatus.OK);
  }

  public ResponseEntity<?> delete(Long id) {
    try {
      if(tipoSectorServiceImpl.FindById(id).equals(false))
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    try {
      tipoSectorServiceImpl.Delete(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(new Mensaje("Tipo de Sector eliminado"), HttpStatus.OK);
  }

}
