package com.SIGER.SIGER.model.entities;

import com.SIGER.SIGER.datos_gob_ar.entities.Localidad;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
