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
