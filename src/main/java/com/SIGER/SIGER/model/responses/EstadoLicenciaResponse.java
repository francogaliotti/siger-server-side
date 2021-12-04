package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("EstadoLicencia")
@Getter
@Setter
public class EstadoLicenciaResponse extends BaseResponse{
	
	private int codEstadoLicencia;
	
	private String nombreEstadoLicencia;

}
