package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("ZonaInhospita")
@Getter
@Setter
public class ZonaInhospitaResponse extends BaseResponse{

  private String codZona;

  private String denominacionZona;

  private float precio;

}
