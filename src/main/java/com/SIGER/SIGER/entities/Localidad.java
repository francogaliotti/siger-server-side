package com.SIGER.SIGER.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Localidad extends BaseEntity{

	private String denominacion;
	
	//Relation
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_departamento")
	private Departamento departamento;

}