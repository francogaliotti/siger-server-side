package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Viatico")
@Getter
@Setter
public class ViaticoResponse extends BaseResponse{

  private String codViatico;

  private String denominacionViatico;

  private double importe;

}
