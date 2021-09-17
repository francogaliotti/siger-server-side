package com.SIGER.SIGER.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class TipoLicencia extends BaseEntity {

	private Date fechaAlta;

	private Date fechaBaja;

	private int cantidadMaximaAnual;
	
	private int cantidadMaximaDiaria;
	
	private int cantidadMaximaMensual;

	private String codigo;

	private String denominacion;
	
	private char generaRequerimiento;
	
	private char justificaRequerimiento;
	
	private int limiteRangoDias;
	
	private String modalidadLicencia;
	
	private String observaciones;
	
	private char permiteSolapamiento;
	
	private String tipoCalculo;
	
	//Relation
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_tipoRequerimiento")
	private TipoRequerimiento tipoRequerimiento;

}