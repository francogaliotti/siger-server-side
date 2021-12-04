package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Provincia")
@Getter
@Setter
public class ProvinciaResponse extends BaseResponse {

  private String codigo;

  private String denominacion;

}
