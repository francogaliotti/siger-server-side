package com.SIGER.SIGER.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class RemanenteDiasLicencia extends BaseEntity{
	
	private int anioRemanente;

	private int diasSobrantes;

	@OneToOne(cascade = CascadeType.MERGE)
	private TipoLicencia tipoLicencia;

}
