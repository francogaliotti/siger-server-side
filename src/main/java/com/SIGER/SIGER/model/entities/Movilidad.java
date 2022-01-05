package com.SIGER.SIGER.model.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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