package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Date;
import java.util.List;

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

  private DocumentoIdentidadResponse documentoIdentidad;

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

  private NacionalidadResponse nacionalidad;

  private UsuarioResponse usuario;

  private DomicilioResponse domicilio;

  private RemuneracionResponse remuneracion;

  private RegimenHorarioResponse regimenHorario;

  private List<HistorialSectorEmpleadoResponse> historialSectorEmpleado;

}
