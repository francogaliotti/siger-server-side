package com.SIGER.SIGER.model.entities.direccion;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "localidades")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Localidad {

	@Column(name = "categoria", nullable = false)
	private String categoria;

	@Column(name = "centroide_lat", nullable = false)
	private String latitud;

	@Column(name = "centroide_lon", nullable = false)
	private String longitud;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "departamento_id", nullable = false)
	private Departamento departamento;

	@Column(name = "departamento_nombre")
	private String departamentoNombre;

	@Column(name = "fuente", nullable = false)
	private String fuente;

	@Id
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "localidad_censal_id", nullable = false)
	private String localidadCensalId;

	@Column(name = "localidad_censal_nombre", nullable = false)
	private String localidadCensalNombre;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "municipio_id", nullable = false)
	private Municipio municipio;

	@Column(name = "municipio_nombre", nullable = false)
	private String municipioNombre;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "provincia_id", nullable = false)
	private Provincia provincia;

	@Column(name = "provincia_nombre", nullable = false)
	private String provinciaNombre;


}