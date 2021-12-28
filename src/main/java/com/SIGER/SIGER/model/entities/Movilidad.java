package com.SIGER.SIGER.model.entities;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Movilidad extends BaseEntity{
	
	private Date fechaAlta;
	
	private Date fechaBaja;

	private String codigo;

	private String patente;
	
	// Relation

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_tipoMovilidad")
	private TipoMovilidad tipoMovilidad;
	
}