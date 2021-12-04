package com.SIGER.SIGER.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegimenHorario extends BaseEntity{

	private Date fechaInicioVigenciaRegimenHorario;

	private Date fechaFinVigenciaRegimenHorario;

	private Date horaMinutoInicioJornadaLaboral;

	private Date horaMinutoFinJornadaLaboral;

	//Relation

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_tipoRegimenHorario")
	private TipoRegimenHorario tipoRegimenHorario;

}
