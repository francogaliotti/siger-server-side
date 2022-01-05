package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.model.entities.TipoRegimenHorario;
import java.time.LocalTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegimenHorarioRequest extends BaseRequest{

  /*private Date fechaInicioVigenciaRegimenHorario;

  private Date fechaFinVigenciaRegimenHorario;*/

  private boolean isActive;

  private LocalTime horaMinutoInicioJornadaLaboral;

  private LocalTime horaMinutoFinJornadaLaboral;

  private TipoRegimenHorario tipoRegimenHorario;

}
