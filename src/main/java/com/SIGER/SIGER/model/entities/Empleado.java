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

	private String legajo;

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
	@OneToOne(cascade = CascadeType.ALL/*, orphanRemoval = true*/)
	private DocumentoIdentidad documentoIdentidad;

	@OneToOne(cascade = CascadeType.MERGE)
	private Nacionalidad nacionalidad;

	@OneToOne(cascade = CascadeType.MERGE/*, orphanRemoval = true*/)
	private Remuneracion remuneracion;
	
	@OneToOne(cascade = CascadeType.MERGE/*, orphanRemoval = true*/)
	private RegimenHorario regimenHorario;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_usuario")
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_domicilio")
	private Domicilio domicilio;
	
	@OneToMany(cascade = CascadeType.ALL/*, orphanRemoval = true*/)
	private List<HistorialSectorEmpleado> historialSectorEmpleado = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL/*, orphanRemoval = true*/)
	private List<ComputoDiasLicencia>computoDiasLicencias = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL/*, orphanRemoval = true*/)
	private List<RemanenteDiasLicencia>remanenteDiasLicencias = new ArrayList<>();

}
