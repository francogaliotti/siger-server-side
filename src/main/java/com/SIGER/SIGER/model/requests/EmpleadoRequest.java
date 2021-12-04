package com.SIGER.SIGER.model.requests;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoRequest extends BaseRequest {

  private String nombre;

  private String apellido;

  private String correoPersonal;

  private int estadoCivil;

  private String nacionalidad;

  private int legajo;

  private String cuil;

  private int tipoDocumento;

  private String nroIdentificacionPersonal;

  private Date fechaNacimiento;

  private String nroTelefonoFijo;

  private String nroTelefonoCelular;

}
