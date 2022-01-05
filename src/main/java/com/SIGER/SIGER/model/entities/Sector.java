package com.SIGER.SIGER.model.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Sector extends BaseEntity{

	private String codigo;

	private String denominacion;
	
	private Date fechaBaja;
	
	private boolean validaFueraDeHorario;
	
	private char detenerCargaBoletas;
	
	private boolean permiteTrabajarHorasExtras;
	
	private boolean permiteTrabajarFinDeSemana;
	
	private int maximoSerenoDiurno;
	
	private int maximoSerenoNocturno;
	
	//Relations
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_sectorSuperior")
	private Sector sectorSuperior;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_tipoSector")
	private TipoSector tipoSector;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_domicilio")
	private Domicilio domicilio;

}