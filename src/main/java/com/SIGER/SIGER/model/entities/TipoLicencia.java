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
public class TipoLicencia extends BaseEntity {


	private int cantidadMaximaAnual;
	
	private int cantidadMaximaDiaria;
	
	private int cantidadMaximaMensual;

	private String codigo;

	private String denominacion;

	private boolean justificaPresentismo;

	private int limiteRangoDias;
	
	private boolean goceSueldo;
	
	private String observaciones;
	
	//Relation
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_tipoRequerimiento")
	private TipoRequerimiento tipoRequerimiento;

}