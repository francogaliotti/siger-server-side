package com.SIGER.SIGER.datos_gob_ar.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Municipio")
@Getter
@Setter
public class MunicipioResponse {

  private String categoria;

  private String latitud;

  private String longitud;

  private String fuente;

  private String id;

  private String nombre;

  private String nombre_completo;

  @Column(name = "provincia_id", nullable = false)
  private String provincia;

  private String provinciaInterseccion;

  private String provinciaNombre;

}
