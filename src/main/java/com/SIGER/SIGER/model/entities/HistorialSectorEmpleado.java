package com.SIGER.SIGER.model.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
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
public class HistorialSectorEmpleado extends BaseEntity{

	private Date fechaIngreso;
	
	private Date fechaSalida;
	
	private boolean vigente;
	
	//Relation
	
	@OneToOne(cascade = CascadeType.ALL)
	private Sector sector;

}
