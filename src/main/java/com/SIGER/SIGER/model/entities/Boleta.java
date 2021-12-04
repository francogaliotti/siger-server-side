package com.SIGER.SIGER.model.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Boleta extends BaseEntity{
	
	private Date fechaAlta;
	
	private Date fechaBaja;

	private String numero;

	private Date fechaHoraLlegada;

	private Date fechaHoraSalida;
	
	private Date fechaHoraPosibleLlegada;
	
	private Date fechaHoraPosibleSalida;

	private int periodo;
	
	private Date fechaCierre;
	
	private Date fechaControl;

	private String observacionesBoleta;
	
	private Date fechaSincronizacion;

	private boolean sinFichadaRetorno;

	private boolean sinFichadaSalida;
	
	//Relations
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_zonaInhospita")
	private ZonaInhospita zonaInhospita;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_viatico")
	private Viatico viatico;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_empleado")
	private Empleado empleado;
	
	@OneToMany(/*mappedBy = "boleta",*/ cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FechaCambioEstadoBoleta> fechasCambioEstadoBoleta = new ArrayList<FechaCambioEstadoBoleta>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DocumentoAdjuntoBoleta> documentosAdjuntosBoleta = new ArrayList<DocumentoAdjuntoBoleta>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "boleta_movilidad",
	joinColumns = @JoinColumn(name = "boleta_id"), 
	inverseJoinColumns = @JoinColumn(name = "movilidad_id"))
	private List<Movilidad> movilidades = new ArrayList<Movilidad>();
	
	@NonNull
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_tipoBoleta")
	private TipoBoleta tipoBoleta;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentarios = new ArrayList<Comentario>();

}
