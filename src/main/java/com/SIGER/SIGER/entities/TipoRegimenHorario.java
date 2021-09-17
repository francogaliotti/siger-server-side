package com.SIGER.SIGER.entities;
import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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