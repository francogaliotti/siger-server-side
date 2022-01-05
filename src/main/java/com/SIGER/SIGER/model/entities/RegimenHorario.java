package com.SIGER.SIGER.model.entities;

import java.time.LocalTime;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
public class RegimenHorario extends BaseEntity{

	private Date fechaInicioVigenciaRegimenHorario;

	private Date fechaFinVigenciaRegimenHorario;

	private LocalTime horaMinutoInicioJornadaLaboral;

	private LocalTime horaMinutoFinJornadaLaboral;

	private boolean isActive;

	//Relation

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_tipoRegimenHorario")
	private TipoRegimenHorario tipoRegimenHorario;

}
