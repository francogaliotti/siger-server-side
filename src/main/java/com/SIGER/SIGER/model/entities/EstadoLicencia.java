package com.SIGER.SIGER.model.entities;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EstadoLicencia extends BaseEntity{
	
	private String codEstadoLicencia;

	private String nombreEstadoLicencia;

}
