package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.model.entities.Empleado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AsistenciaRequest extends BaseRequest{

  private String fechaHora;

  private char tipoMovimiento;

  private Empleado empleado;

}