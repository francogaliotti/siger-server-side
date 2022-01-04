package com.SIGER.SIGER.model.entities;

import com.SIGER.SIGER.model.entities.Datos_gob_ar.Localidad;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Domicilio extends BaseEntity{

	private String calle;
	
	private int nroCalle;
	
	private String departamento;
	
	private int nroPiso;
	private String barrio;
	private String manzana;
	private String casa;

	
	//Relation
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_localidad")
	private Localidad localidad;

}
