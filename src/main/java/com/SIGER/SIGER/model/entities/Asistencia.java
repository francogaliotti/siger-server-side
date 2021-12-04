package com.SIGER.SIGER.model.entities;
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Asistencia extends BaseEntity {
	
	private Date fechaAlta;
	
	private Date fechaBaja;

	private Date fechaHora;
	
	private Date fechaCierre;
	
	private Date fechaModificacion;
	
	private Date fechaSincronizacion;

	private int reloj;

	private boolean supervisor;

	private String tipoMovimiento;
	
	private String excesoHorario;
	
	private int horaAsignado;
	
	private int minutoAsignado;

	private boolean viaticoGabinete;
	
	//Relation
	
	@NonNull
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_empleado")
	private Empleado empleado;

}	
