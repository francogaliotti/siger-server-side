package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Empleado")
@Getter
@Setter
public class EmpleadoResponse extends BaseResponse{

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
