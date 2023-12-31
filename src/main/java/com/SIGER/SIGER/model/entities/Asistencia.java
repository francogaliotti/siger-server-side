package com.SIGER.SIGER.model.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Asistencia extends BaseEntity {
	
	private Date fechaAlta;
	
	private Date fechaBaja;

	private String fechaHora;
	
	private Date fechaCierre;
	
	private Date fechaModificacion;
	
	private Date fechaSincronizacion;

	private String reloj;

	private boolean supervisor;

	private char tipoMovimiento;
	
	private String excesoHorario;
	
	private int horaAsignado;
	
	private int minutoAsignado;

	private boolean viaticoGabinete;
	
	//Relation
	
	@NonNull
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_empleado")
	private Empleado empleado;

}	
