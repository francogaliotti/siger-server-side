package com.SIGER.SIGER.model.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.SIGER.SIGER.security.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Empleado extends BaseEntity{
	
	private Date fechaAlta;
	
	private Date fechaBaja;

	private String nombre;

	private String apellido;

	private String correoPersonal;

	private int estadoCivil;

	private String nacionalidad;

	private int legajo;

	private String cuil;

	private int tipoDocumento;

	private String nroIdentificacionPersonal;
	
	private Date fechaLimiteReemplazo;

	private Date fechaNacimiento;
	
	private int diasLicenciaAnualFija;
	
	private Date fechaIngreso;
	
	private boolean rompeReglaComisionDia;
	
	private boolean rompeReglaFichadaReloj;
	
	private boolean puedeAprobarRequerimiento;
	
	private boolean rompeReglaFichadaSupervisor;
	
	private boolean esEncargado;
	
	private String nroTelefonoFijo;

	private String nroTelefonoCelular;
	
	//Relations
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Remuneracion> remuneraciones = new ArrayList<Remuneracion>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RegimenHorario> regimenesHorario = new ArrayList<RegimenHorario>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_usuario")
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_domicilio")
	private Domicilio domicilio;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HistorialSectorEmpleado> historialSectorEmpleado = new ArrayList<HistorialSectorEmpleado>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Planilla> planillas = new ArrayList<Planilla>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ComputoDiasLicencia>computoDiasLicencias = new ArrayList<ComputoDiasLicencia>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RemanenteDiasLicencia>remanenteDiasLicencias = new ArrayList<RemanenteDiasLicencia>();

}
