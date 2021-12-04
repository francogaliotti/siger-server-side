package com.SIGER.SIGER.model.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViaticoRequest extends BaseRequest{

  private String codViatico;

  private String denominacionViatico;

  private double importe;

}
