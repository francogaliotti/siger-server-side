package com.SIGER.SIGER.model.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoRegimenHorarioRequest extends BaseRequest{

  private String codigoTipoRegimenHorario;

  private String denominacionTipoRegimenHorario;

}
