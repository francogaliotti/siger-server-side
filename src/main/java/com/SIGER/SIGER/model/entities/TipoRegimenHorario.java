package com.SIGER.SIGER.model.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*agregue la rama jornada laboral  */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TipoRegimenHorario extends BaseEntity{
	
	private String codigoTipoRegimenHorario;

	private String denominacionTipoRegimenHorario;

}