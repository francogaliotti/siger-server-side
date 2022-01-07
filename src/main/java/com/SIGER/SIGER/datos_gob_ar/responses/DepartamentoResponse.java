package com.SIGER.SIGER.datos_gob_ar.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Departamento")
@Getter
@Setter
public class DepartamentoResponse {

  private String categoria;

  private String latitud;

  private String longitud;

  private String fuente;

  private String id;

  private String nombre;

  private String nombre_completo;

  private String provincia;

  private String provinciaInterseccion;

  private String provinciaNombre;

}
