package com.SIGER.SIGER.model.entities;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FechaCambioEstadoBoleta extends BaseEntity{

	private Date fechaCambioEstadoBoleta;
	
	//Relations

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_empleadoEvaluadorBoleta")
	private Empleado empleadoEvaluadorBoleta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_estadoBoleta")
	private EstadoBoleta estadoBoleta;

}
