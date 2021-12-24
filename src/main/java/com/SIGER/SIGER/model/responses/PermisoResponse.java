package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Permiso")
@Getter
@Setter
public class PermisoResponse extends BaseResponse{

  private String codigoPermiso;

  private String nombrePermiso;

}
