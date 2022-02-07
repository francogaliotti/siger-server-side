package com.SIGER.SIGER.model.entities;

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
public class TipoLicencia extends BaseEntity {

	private String codigo;

	private String denominacion;

	private boolean justificaPresentismo;

	private boolean goceSueldo;

	private int cantidadMaximaAnual;

	private int cantidadMaximaDiaria;

	private int cantidadMaximaMensual;

	private int limiteRangoDias;

	private String observaciones;

	//Relation

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_tipoRequerimiento")
	private TipoRequerimiento tipoRequerimiento;

}