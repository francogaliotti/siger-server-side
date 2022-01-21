package com.SIGER.SIGER.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Licencia extends BaseEntity{
	
	private Date fechaAlta;
	
	private Date fechaBaja;

	private Date fechaInicioLicencia;

	private Date fechaFinLicencia;
	
	private Date fechaFrancoCompensatorio;
	
	private Date fechaCierre;
	
	private Date fechaControl;
	
	private Date fechaSincronizacion;
	
	private String observacionesLicencia;
	
	//Relations
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentarios = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DocumentoAdjuntoLicencia> documentosAdjuntosLicencia = new ArrayList<>();
	
	@NonNull
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_tipoLicencia")
	private TipoLicencia tipoLicencia;
	
	@OneToMany(/*mappedBy = "licencia",*/cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FechaCambioEstadoLicencia> fechasCambioEstadoLicencia = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_empleado")
	private Empleado empleado;


}
