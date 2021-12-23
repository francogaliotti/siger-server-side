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

@Entity(name = "municipios")
@AllArgsConstructor
@NoArgsConstructor
@Data
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

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "provincia_id", nullable = false)
  private Provincia provincia;

  @Column(name = "provincia_interseccion", nullable = false)
  private String provinciaInterseccion;

  @Column(name = "provincia_nombre", nullable = false)
  private String provinciaNombre;

}
