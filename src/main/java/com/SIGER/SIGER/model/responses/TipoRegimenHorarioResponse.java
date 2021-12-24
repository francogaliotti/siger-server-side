package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Tipo Regimen Horario")
@Getter
@Setter
public class TipoRegimenHorarioResponse extends BaseResponse{

  private String codigoTipoRegimenHorario;

  private String denominacionTipoRegimenHorario;

}
