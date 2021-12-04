package com.SIGER.SIGER.model.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoLicenciaRequest extends BaseRequest{
	
	private String codEstadoLicencia;
	
	private String nombreEstadoLicencia;

}
