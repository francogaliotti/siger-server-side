package com.SIGER.SIGER.model.responses;

import com.SIGER.SIGER.model.entities.TipoRegimenHorario;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Regimen Horario")
@Getter
@Setter
public class RegimenHorarioResponse extends BaseResponse{

  private Date fechaInicioVigenciaRegimenHorario;

  private Date fechaFinVigenciaRegimenHorario;

  private Date horaMinutoInicioJornadaLaboral;

  private Date horaMinutoFinJornadaLaboral;

  private TipoRegimenHorario tipoRegimenHorario;

}
