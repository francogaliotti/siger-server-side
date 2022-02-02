package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.common.ValidationMessages;
import com.SIGER.SIGER.model.entities.ComputoDiasLicencia;
import com.SIGER.SIGER.model.entities.Planilla;
import com.SIGER.SIGER.model.entities.RegimenHorario;
import com.SIGER.SIGER.model.entities.RemanenteDiasLicencia;
import com.SIGER.SIGER.model.entities.Remuneracion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

  private DocumentoIdentidadRequest documentoIdentidad;

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

  private NacionalidadRequest nacionalidad;

  private RemuneracionRequest remuneracion;

  private RegimenHorarioRequest regimenHorario;

  private UsuarioRequest usuario;

  private DomicilioRequest domicilio;

  private List<HistorialSectorEmpleadoRequest> historialSectorEmpleado;

  //private List<Planilla> planillas = new ArrayList<>();

  /*private List<ComputoDiasLicencia> computoDiasLicencias = new ArrayList<>();

  private List<RemanenteDiasLicencia> remanenteDiasLicencias = new ArrayList<>();*/

}
