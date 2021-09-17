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
public class TipoBoleta extends BaseEntity{

	private String codigo;

	private String denominacion;
	
	private boolean tieneMovilidad;
	
	private boolean tineZonaInhospita;
	
	private boolean tieneViatico;
	
	private boolean permiteNoFichadaRetorno;
	
	private boolean permiteNoFichadaSalida;
	
	//Relation
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_tipoRequerimiento")
	private TipoRequerimiento tipoRequerimiento;

}