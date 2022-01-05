package com.SIGER.SIGER.model.entities;

import com.SIGER.SIGER.security.entity.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class Empleado extends BaseEntity{
	
	private Date fechaAlta;
	
	private Date fechaBaja;

	private String nombre;

	private String apellido;

	private String correoPersonal;

	private int estadoCivil;

	private int legajo;

	private String cuil;

	private int tipoDocumento;

	private String nroIdentificacionPersonal;
	
	private Date fechaLimiteReemplazo;

	private Date fechaNacimiento;
	
	private Date fechaIngreso;
	
	private boolean rompeReglaComisionDia;
	
	private boolean rompeReglaFichadaReloj;
	
	private boolean puedeAprobarRequerimiento;
	
	private boolean rompeReglaFichadaSupervisor;
	
	private boolean esEncargado;
	
	private String nroTelefonoFijo;

	private String nroTelefonoCelular;
	
	//Relations
	@OneToOne(cascade = CascadeType.MERGE)
	private Nacionalidad nacionalidad;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Remuneracion> remuneraciones = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RegimenHorario> regimenesHorario = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_usuario")
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_domicilio")
	private Domicilio domicilio;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HistorialSectorEmpleado> historialSectorEmpleado = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Planilla> planillas = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ComputoDiasLicencia>computoDiasLicencias = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RemanenteDiasLicencia>remanenteDiasLicencias = new ArrayList<>();

}
