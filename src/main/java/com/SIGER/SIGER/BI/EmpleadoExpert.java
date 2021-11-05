package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.entities.Empleado;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.servicesImpl.EmpleadoServiceImpl;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoExpert {

  @Autowired
  EmpleadoServiceImpl empleadoServiceImpl;

  public ResponseEntity<List<Empleado>> getAll() {
    List<Empleado> empleados = null;
    try {
      empleados = empleadoServiceImpl.FindAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(empleados, HttpStatus.OK);
  }

  public ResponseEntity<?> getOne(Long id) {
    try {
      if (empleadoServiceImpl.FindById(id).equals(false)) {
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    Empleado empleado = null;
    try {
      empleado = empleadoServiceImpl.FindById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(empleado, HttpStatus.OK);
  }

  /*public ResponseEntity<Empleado> getByNombre(String nombre){
    if(!empleadoServiceImpl.existsByNombre(nombre))
      return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
    Empleado empleado = empleadoServiceImpl.getByNombre(nombre).get();
    return new ResponseEntity(empleado, HttpStatus.OK);
  }*/

  public ResponseEntity<?> save(Empleado empleado) {
    if (StringUtils.isBlank(empleado.getNombre())) {
      return new ResponseEntity(new Mensaje("El nombre del Empleado es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (StringUtils.isBlank(empleado.getApellido())) {
      return new ResponseEntity(new Mensaje("El apellido del Empleado es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (empleadoServiceImpl.existsByLegajo(empleado.getLegajo())) {
      return new ResponseEntity(new Mensaje("El legajo del Empleado ya existe"),
          HttpStatus.BAD_REQUEST);
    }
    if (empleadoServiceImpl.existsByCuil(empleado.getCuil())) {
      return new ResponseEntity(new Mensaje("El CUIL del Empleado ya existe"),
          HttpStatus.BAD_REQUEST);
    }
    if (empleadoServiceImpl.existsByNroIdentificacionPersonal(
        empleado.getNroIdentificacionPersonal())) {
      return new ResponseEntity(
          new Mensaje("El Número de Identificación personal del Empleado ya existe"),
          HttpStatus.BAD_REQUEST);
    }

    Empleado empleado1 = Empleado.builder()
        .nombre(empleado.getNombre())
        .apellido(empleado.getApellido())
        .nroTelefonoFijo(empleado.getNroTelefonoFijo())
        .nroTelefonoCelular(empleado.getNroTelefonoCelular())
        .correoPersonal(empleado.getCorreoPersonal())
        .fechaNacimiento(empleado.getFechaNacimiento())
        .estadoCivil(empleado.getEstadoCivil())
        .nacionalidad(empleado.getNacionalidad())
        .tipoDocumento(empleado.getTipoDocumento())
        .nroIdentificacionPersonal(empleado.getNroIdentificacionPersonal())
        .cuil(empleado.getCuil())
        .legajo(empleado.getLegajo())
        .build();
    try {
      empleadoServiceImpl.Save(empleado1);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(new Mensaje("Empleado creado"), HttpStatus.OK);
  }

  public ResponseEntity<?> update(Long id, Empleado empleado) {
    try {
      if (empleadoServiceImpl.FindById(id).equals(false)) {
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
      }
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    if (StringUtils.isBlank(empleado.getNombre())) {
      return new ResponseEntity(new Mensaje("El nombre del Empleado es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (StringUtils.isBlank(empleado.getApellido())) {
      return new ResponseEntity(new Mensaje("El apellido del Empleado es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }

    try {
      Empleado empleado1 = empleadoServiceImpl.FindById(id);

      empleado1.setCorreoPersonal(empleado.getCorreoPersonal());
      empleado1.setNroTelefonoCelular(empleado1.getNroTelefonoCelular());
      empleado1.setNroTelefonoFijo(empleado1.getNroTelefonoFijo());
      empleado1.setDomicilio(empleado.getDomicilio());
      empleado1.setEstadoCivil(empleado1.getEstadoCivil());
      empleado1.setFechaLimiteReemplazo(empleado.getFechaLimiteReemplazo());
      empleado1.setDiasLicenciaAnualFija(empleado.getDiasLicenciaAnualFija());
      empleado1.setRompeReglaComisionDia(empleado.isRompeReglaComisionDia());
      empleado1.setRompeReglaFichadaReloj(empleado1.isRompeReglaFichadaReloj());
      empleado1.setRompeReglaFichadaSupervisor(empleado1.isRompeReglaFichadaSupervisor());
      empleado1.setPuedeAprobarRequerimiento(empleado1.isPuedeAprobarRequerimiento());
      empleado1.setEsEncargado(empleado1.isEsEncargado());

      empleadoServiceImpl.Update(id, empleado1);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(new Mensaje("Empleado actualizado"), HttpStatus.OK);
  }

  public ResponseEntity<?> delete(Long id) {
    try {
      if (empleadoServiceImpl.FindById(id).equals(false)) {
        return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
      }
    } catch (Exception e1) {
      e1.printStackTrace();
    }
    try {
      empleadoServiceImpl.Delete(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity(new Mensaje("Empleado eliminado"), HttpStatus.OK);
  }

}
