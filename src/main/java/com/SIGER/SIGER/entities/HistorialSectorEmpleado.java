package com.SIGER.SIGER.entities;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class HistorialSectorEmpleado extends BaseEntity{

	private Date fechaIngreso;
	
	private Date fechaSalida;
	
	private boolean vigente;
	
	//Relation
	
	@OneToOne(cascade = CascadeType.ALL)
	private Sector sector;

}
