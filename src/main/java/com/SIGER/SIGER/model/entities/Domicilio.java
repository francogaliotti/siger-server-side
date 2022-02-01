package com.SIGER.SIGER.model.entities;

import com.SIGER.SIGER.datos_gob_ar.entities.Departamento;
import com.SIGER.SIGER.datos_gob_ar.entities.Localidad;
import com.SIGER.SIGER.datos_gob_ar.entities.Municipio;
import com.SIGER.SIGER.datos_gob_ar.entities.Provincia;
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
	
	private int nroDepartamento;
	
	private int nroPiso;

	
	//Relation

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_provincia")
	private Provincia provincia;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_departamento")
	private Departamento departamento;

	/*@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_municipio")
	private Municipio municipio;*/


	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_localidad")
	private Localidad localidad;

}
