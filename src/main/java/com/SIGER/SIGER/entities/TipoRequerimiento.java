package com.SIGER.SIGER.entities;

import java.util.ArrayList;
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
public class TipoRequerimiento extends BaseEntity{

	private String tipoRequerimientoDenominacion;

	private int cantNiveles;
	
	//Relations
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Sector> aprueban = new ArrayList<Sector>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Empleado> aprobadores = new ArrayList<Empleado>();

}