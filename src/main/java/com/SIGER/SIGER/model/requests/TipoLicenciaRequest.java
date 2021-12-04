package com.SIGER.SIGER.model.requests;

import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoLicenciaRequest extends BaseRequest{

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
