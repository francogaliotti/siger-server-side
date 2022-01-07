package com.SIGER.SIGER.datos_gob_ar.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Localidad")
@Getter
@Setter
public class LocalidadResponse {

  private String categoria;

  private String latitud;

  private String longitud;

  private String departamento;

  private String departamentoNombre;

  private String fuente;

  private String id;

  private String localidadCensalId;

  private String localidadCensalNombre;

  private String municipio;

  private String municipioNombre;

  private String nombre;

  @Column(name = "provincia_id", nullable = false)
  private String provincia;

  private String provinciaNombre;

}
