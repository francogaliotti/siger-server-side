package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.model.entities.TipoRegimenHorario;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegimenHorarioRequest extends BaseRequest{

  private Date fechaInicioVigenciaRegimenHorario;

  private Date fechaFinVigenciaRegimenHorario;

  private Date horaMinutoInicioJornadaLaboral;

  private Date horaMinutoFinJornadaLaboral;

  private TipoRegimenHorario tipoRegimenHorario;

}
