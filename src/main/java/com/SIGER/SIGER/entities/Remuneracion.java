package com.SIGER.SIGER.entities;

import java.util.Date;

import javax.persistence.Entity;
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
public class Remuneracion extends BaseEntity{

	private double valorHora;

	private double valorViaticoDia;
	
	private double importeHorasAdicionales;
	
	private double importeZonaDesarraigo;

}