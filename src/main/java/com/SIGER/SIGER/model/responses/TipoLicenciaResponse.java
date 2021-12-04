package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("TipoLicencia")
@Getter
@Setter
public class TipoLicenciaResponse extends BaseResponse{

  @Id
  @Column(name = "id", nullable = false)
  private String codigo;

  private String denominacion;

  private boolean justificaPresentismo;

  private char generaRequerimiento;

  private char justificaRequerimiento;

  private int limiteRangoDias;

  private String modalidadLicencia;

  private String observaciones;

  private char permiteSolapamiento;

  private String tipoCalculo;

  public int tipoRequerimientoCantNiveles;

  public String tipoRequerimientoDenominacion;

}
