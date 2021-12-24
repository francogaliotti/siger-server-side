package com.SIGER.SIGER.model.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TipoRequerimiento extends BaseEntity{

	private String tipoRequerimientoDenominacion;

	private int cantNiveles;
	
	//Relations
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "tipo_requerimiento_sector",
			joinColumns = @JoinColumn(name = "tipo_requerimiento_id"),
			inverseJoinColumns = @JoinColumn(name = "sector_id"))
	private List<Sector> aprueban = new ArrayList<Sector>();


	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "tipo_requerimiento_empleado",
			joinColumns = @JoinColumn(name = "tipo_requerimiento_id"),
			inverseJoinColumns = @JoinColumn(name = "empleado_id"))
	private List<Empleado> aprobadores = new ArrayList<Empleado>();

}