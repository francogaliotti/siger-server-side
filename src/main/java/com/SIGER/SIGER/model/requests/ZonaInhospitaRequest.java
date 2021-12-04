package com.SIGER.SIGER.model.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZonaInhospitaRequest extends BaseRequest{

  private String codZona;

  private String denominacionZona;

  private float precio;

}
