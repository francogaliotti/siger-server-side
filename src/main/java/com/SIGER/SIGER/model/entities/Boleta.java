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

	private String mensajeRechazo;
	
	private Date fechaSincronizacion;

	private boolean sinFichadaRetorno;

	private boolean sinFichadaSalida;

	//Relations

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_zonaInhospita", nullable = true)
	private ZonaInhospita zonaInhospita;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_viatico", nullable = true)
	private Viatico viatico;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_empleado")
	private Empleado empleado;
	
	@OneToMany(/*mappedBy = "boleta",*/ cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FechaCambioEstadoBoleta> fechasCambioEstadoBoleta = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DocumentoAdjuntoBoleta> documentosAdjuntosBoleta = new ArrayList<>();

	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.MERGE})
	@JoinTable(name = "boleta_movilidad",
			joinColumns = @JoinColumn(name = "boleta_id", nullable = true),
			inverseJoinColumns = @JoinColumn(name = "movilidad_id", nullable = true))
	private List<Movilidad> movilidades = new ArrayList<>();
	
	@NonNull
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_tipoBoleta")
	private TipoBoleta tipoBoleta;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentarios = new ArrayList<>();


}
