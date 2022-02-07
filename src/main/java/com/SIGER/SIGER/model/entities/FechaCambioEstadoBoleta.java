package com.SIGER.SIGER.model.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class FechaCambioEstadoBoleta extends BaseEntity{

	private Date fechaCambioEstadoBoleta;

	private Date fechaFinEstadoBoleta;
	
	//Relations

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_empleadoEvaluadorBoleta")
	private Empleado empleadoEvaluadorBoleta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_estadoBoleta")
	private EstadoBoleta estadoBoleta;

}
