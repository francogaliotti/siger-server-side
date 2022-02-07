package com.SIGER.SIGER.model.entities;

import javax.persistence.Entity;
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
public class Remuneracion extends BaseEntity{

	private String denominacion;

	private double valorHora;

	private double valorViaticoDia;
	
	private double importeHorasAdicionales;
	
	private double importeZonaDesarraigo;

}