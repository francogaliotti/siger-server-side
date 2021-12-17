package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("EstadoBoleta")
@Getter
@Setter
public class EstadoBoletaResponse extends BaseResponse{
	
	private String codEstadoBoleta;
	
	private String nombreEstadoBoleta;

}
