package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.entities.Sector;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.servicesImpl.SectorServiceImpl;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SectorExpert {

  @Autowired
  SectorServiceImpl sectorServiceImpl;

  public ResponseEntity<List<Sector>> getAll() {
    List<Sector> sectores = null;
    try {
      sectores = sectorServiceImpl.FindAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(sectores, HttpStatus.OK);
  }

  public ResponseEntity<?> getOne(Long id) {
    try {
      if(sectorServiceImpl.FindById(id).equals(false))
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      e.printStackTrace();
    }
    Sector sector = null;
    try {
      sector = sectorServiceImpl.FindById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(sector, HttpStatus.OK);
  }

  /*public ResponseEntity<Sector> getByNombre(String denominacion){
    if(!sectorServiceImpl.existsByDenominacion(denominacion))
      return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    Sector sector = sectorServiceImpl.getByDenominacion(denominacion).get();
    return new ResponseEntity(sector, HttpStatus.OK);
  }*/

  public ResponseEntity<?> save(Sector sector) {
    if(StringUtils.isBlank(sector.getDenominacion()))
      return new ResponseEntity(new Mensaje("El nombre del Sector es obligatorio"), HttpStatus.BAD_REQUEST);
    if(sector.getCodigo().length()<0)
      return new ResponseEntity(new Mensaje("El código es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
    if(sectorServiceImpl.existsByDenominacion(sector.getDenominacion()))
      return new ResponseEntity(new Mensaje("El nombre del Sector ya existe"), HttpStatus.BAD_REQUEST);
    Sector sector1 = Sector.builder().codigo(sector.getCodigo())
        .denominacion(sector.getDenominacion())
        .validaFueraDeHorario(sector.getValidaFueraDeHorario())
        .permiteTrabajarHorasExtras(sector.isPermiteTrabajarHorasExtras())
        .permiteTrabajarFinDeSemana(sector.isPermiteTrabajarFinDeSemana())
        .maximoSerenoDiurno(sector.getMaximoSerenoDiurno())
        .maximoSerenoNocturno(sector.getMaximoSerenoNocturno())
        .sectorSuperior(sector.getSectorSuperior())
        .tipoSector(sector.getTipoSector())
        .domicilio(sector.getDomicilio())
        .build();
    try {
      sectorServiceImpl.Save(sector1);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(new Mensaje("Sector creado"), HttpStatus.OK);
  }

  public ResponseEntity<?> update(Long id, Sector sector) {
    try {
      if(sectorServiceImpl.FindById(id).equals(false))
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    if(StringUtils.isBlank(sector.getDenominacion()))
      return new ResponseEntity(new Mensaje("El nombre del Sector es obligatorio"), HttpStatus.BAD_REQUEST);
    if(sector.getCodigo().length()<0)
      return new ResponseEntity(new Mensaje("El código es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

    try {
      Sector sector1 = sectorServiceImpl.FindById(id);
      sector1.setCodigo(sector.getCodigo());
      sector1.setDenominacion(sector.getDenominacion());
      sector1.setValidaFueraDeHorario(sector.getValidaFueraDeHorario());
      sector1.setPermiteTrabajarHorasExtras(sector.isPermiteTrabajarHorasExtras());
      sector1.setPermiteTrabajarFinDeSemana(sector.isPermiteTrabajarFinDeSemana());
      sector1.setMaximoSerenoDiurno(sector.getMaximoSerenoDiurno());
      sector1.setMaximoSerenoNocturno(sector.getMaximoSerenoNocturno());
      sector1.setSectorSuperior(sector.getSectorSuperior());
      sector1.setTipoSector(sector.getTipoSector());
      sector1.setDomicilio(sector.getDomicilio());
      sectorServiceImpl.Update(id, sector1);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(new Mensaje("Sector actualizado"), HttpStatus.OK);
  }

  public ResponseEntity<?> delete(Long id) {
    try {
      if(sectorServiceImpl.FindById(id).equals(false))
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    try {
      sectorServiceImpl.Delete(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(new Mensaje("Sector eliminado"), HttpStatus.OK);
  }

}
