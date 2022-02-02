package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.model.entities.Empleado;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AsistenciaRequest extends BaseRequest{

  private LocalDateTime fechaHora;

  private String tipoMovimiento;

  private Empleado empleado;

}