package com.SIGER.SIGER.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EstadoLicenciaDTO {
	
	private int codEstadoLicencia;
	
	private String nombreEstadoLicencia;

}
