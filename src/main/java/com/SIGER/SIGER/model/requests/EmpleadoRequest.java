package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.common.ValidationMessages;
import com.SIGER.SIGER.model.entities.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.SIGER.SIGER.security.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoRequest extends BaseRequest {

  @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
  @Size(max = 250, message = ValidationMessages.REQUEST_PARAM_MAX_ERROR_MESSAGE)
  private String nombre;

  @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
  @Size(max = 250, message = ValidationMessages.REQUEST_PARAM_MAX_ERROR_MESSAGE)
  private String apellido;

  private String correoPersonal;

  private int estadoCivil;

  private String legajo;

  private DocumentoIdentidad documentoIdentidad;

  //private String nroIdentificacionPersonal;

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

  private Remuneracion remuneracion;

  private RegimenHorario regimenHorario;

  private Usuario usuario;

  private Domicilio domicilio;

  private Sector sector;

  //private List<Planilla> planillas = new ArrayList<>();

  private List<ComputoDiasLicencia> computoDiasLicencias = new ArrayList<>();

  private List<RemanenteDiasLicencia> remanenteDiasLicencias = new ArrayList<>();

}
