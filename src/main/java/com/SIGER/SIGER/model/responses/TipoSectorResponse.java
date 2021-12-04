package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("TipoSector")
@Getter
@Setter
public class TipoSectorResponse extends BaseResponse{

  private String codTipoSector;

  private String nombreTipoSector;

}
