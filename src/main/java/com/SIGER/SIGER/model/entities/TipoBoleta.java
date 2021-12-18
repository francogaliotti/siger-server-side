package com.SIGER.SIGER.model.entities;

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
public class TipoBoleta extends BaseEntity{

	private String codigo;

	private String tipoBoletaDenominacion;
	
	private boolean tieneMovilidad;
	
	private boolean tieneZonaInhospita;
	
	private boolean tieneViatico;
	
	private boolean permiteNoFichadaRetorno;
	
	private boolean permiteNoFichadaSalida;
	
	//Relation
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_tipoRequerimiento")
	private TipoRequerimiento tipoRequerimiento;

}