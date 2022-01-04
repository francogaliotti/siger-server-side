package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.common.ValidationMessages;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.SIGER.SIGER.model.entities.Domicilio;
import com.SIGER.SIGER.model.responses.DocumentoIdentidadResponse;
import com.SIGER.SIGER.model.responses.HistorialSectorEmpleadoResponse;
import com.SIGER.SIGER.model.responses.NacionalidadResponse;
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

  private int legajo;

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

  private UsuarioRequest usuario;

  private DomicilioRequest domicilio;

  private List<HistorialSectorEmpleadoRequest> historialSectorEmpleado;

}
