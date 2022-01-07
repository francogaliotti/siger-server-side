package com.SIGER.SIGER.datos_gob_ar.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Provincia")
@Getter
@Setter
public class ProvinciaResponse {

  private String categoria;

  private String latitud;

  private String longitud;

  private String fuente;

  private String id;

  private String iso_id;

  private  String iso_nombre;

  private String nombre;

  private String nombre_completo;

}
