package com.SIGER.SIGER.model.responses;

import com.SIGER.SIGER.model.entities.Empleado;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@JsonRootName("Asistencia")
@Getter
@Setter
public class AsistenciaResponse extends BaseResponse{

  private Date fechaAlta;

  private Date fechaBaja;

  private String fechaHora;

  private Date fechaCierre;

  private Date fechaModificacion;

  private Date fechaSincronizacion;

  private String reloj;

  private boolean supervisor;

  private char tipoMovimiento;

  private String excesoHorario;

  private int horaAsignado;

  private int minutoAsignado;

  private boolean viaticoGabinete;

  private Empleado empleado;

}
