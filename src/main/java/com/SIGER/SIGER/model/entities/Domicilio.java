package com.SIGER.SIGER.model.entities;

import com.SIGER.SIGER.model.entities.direccion.Localidad;
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
	
	private int nroDepartamento;
	
	private int nroPiso;
	
	//Relation
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_localidad")
	private Localidad localidad;

}
