package com.SIGER.SIGER.model.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class TipoRequerimiento extends BaseEntity{

	private String tipoRequerimientoDenominacion;

	private int cantNiveles;
	
	//Relations
	
	@ManyToMany(/*cascade = CascadeType.MERGE*/)
	@JoinTable(name = "tipo_requerimiento_sector",
			joinColumns = @JoinColumn(name = "tipo_requerimiento_id"),
			inverseJoinColumns = @JoinColumn(name = "sector_id"))
	private List<Sector> aprueban = new ArrayList<>();


	@ManyToMany(/*cascade = CascadeType.MERGE*/)
	@JoinTable(name = "tipo_requerimiento_empleado",
			joinColumns = @JoinColumn(name = "tipo_requerimiento_id"),
			inverseJoinColumns = @JoinColumn(name = "empleado_id"))
	private List<Empleado> aprobadores = new ArrayList<>();

}