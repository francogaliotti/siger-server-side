package com.SIGER.SIGER.entities;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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
