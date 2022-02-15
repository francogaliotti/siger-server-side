package com.SIGER.SIGER.model.responses;

import com.SIGER.SIGER.model.entities.Empleado;
import com.SIGER.SIGER.model.entities.Sector;
import com.fasterxml.jackson.annotation.JsonRootName;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonRootName("TipoLicencia")
@Getter
@Setter
public class TipoLicenciaResponse extends BaseResponse{

  @Id
  @Column(name = "id", nullable = false)

  private String codigo;

  private String denominacion;

  private boolean justificaPresentismo;

  private int limiteRangoDias;

  private boolean goceSueldo;

  private String observaciones;

  private int cantidadMaximaAnual;

  public int tipoRequerimientoCantNiveles;

  public String tipoRequerimientoDenominacion;

  public List<Sector> tipoRequerimientoAprueban = new ArrayList<>();

  public List<Empleado> tipoRequerimientoAprobadores = new ArrayList<>();

}
