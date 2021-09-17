package com.SIGER.SIGER.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_tipoMovilidad")
	private TipoMovilidad tipoMovilidad;
	
}