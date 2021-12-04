package com.SIGER.SIGER.model.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Planilla extends BaseEntity{

	private Date fechaProcesamiento;
	
	private Date fechaDesde;
	
	private Date fechaHasta;
	
	private float totalGabinete;
	
	private float totalGabineteParcial;
	
	private float totalGabinetesCompletos;
	
	private float totalGabinetesCompletosEstadia;
	
	private float totalGabineteDesarraigo;
	
	private float totalGabineteSereno;
	
	//Relations
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Boleta> boletas = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Asistencia> asistencias = new ArrayList<Asistencia>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Licencia> licencias = new ArrayList<Licencia>();

}