package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.model.entities.Empleado;
import com.SIGER.SIGER.model.entities.Sector;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TipoLicenciaRequest extends BaseRequest{

  private String codigo;

  private String denominacion;

  private boolean justificaPresentismo;

  private int limiteRangoDias;

  private boolean goceSueldo;

  private int cantidadMaximaAnual;

  private String observaciones;

  public int tipoRequerimientoCantNiveles;

  public String tipoRequerimientoDenominacion;

  public List<Sector> tipoRequerimientoAprueban = new ArrayList<Sector>();

  public List<Empleado> tipoRequerimientoAprobadores = new ArrayList<Empleado>();

}
