package com.SIGER.SIGER.model.responses;

import com.SIGER.SIGER.model.entities.*;
import com.SIGER.SIGER.security.entity.Usuario;
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

  private int legajo;

  private DocumentoIdentidad documentoIdentidad;

  private String nroIdentificacionPersonal;

  private Date fechaLimiteReemplazo;

  private Date fechaNacimiento;

  private Date fechaIngreso;

  private boolean rompeReglaComisionDia;

  private boolean rompeReglaFichadaReloj;

  private boolean puedeAprobarRequerimiento;

  private boolean rompeReglaFichadaSupervisor;

  private boolean esEncargado;

  private String nroTelefonoFijo;

  private String nroTelefonoCelular;

  private Nacionalidad nacionalidad;

  private Usuario usuario;

  private Domicilio domicilio;

  private Remuneracion remuneracion;

  private RegimenHorario regimenHorario;

  private Sector sector;

}
