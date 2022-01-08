package com.SIGER.SIGER.datos_gob_ar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "municipios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Municipio {

  @Column(name = "categoria", nullable = false)
  private String categoria;

  @Column(name = "centroide_lat", nullable = false)
  private String latitud;

  @Column(name = "centroide_lon", nullable = false)
  private String longitud;

  @Column(name = "fuente", nullable = false)
  private String fuente;

  @Id
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "nombre", nullable = false)
  private String nombre;

  @Column(name = "nombre_completo", nullable = false)
  private String nombre_completo;

  //@ManyToOne(cascade = CascadeType.PERSIST)
  //@JoinColumn(name = "provincia_id", nullable = false)
  @Column(name = "provincia_id", nullable = false)
  private String provincia;

  @Column(name = "provincia_interseccion", nullable = false)
  private String provinciaInterseccion;

  @Column(name = "provincia_nombre", nullable = false)
  private String provinciaNombre;

}
