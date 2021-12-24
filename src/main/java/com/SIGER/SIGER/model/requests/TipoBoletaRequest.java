package com.SIGER.SIGER.model.requests;

import javax.validation.constraints.NotBlank;

import com.SIGER.SIGER.model.entities.Empleado;
import com.SIGER.SIGER.model.entities.Sector;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TipoBoletaRequest extends BaseRequest{

  private Long id;

  private String codigo;

  @NotBlank
  private String tipoBoletaDenominacion;

  private boolean tieneMovilidad;

  private boolean tieneZonaInhospita;

  private boolean tieneViatico;

  private boolean permiteNoFichadaRetorno;

  private boolean permiteNoFichadaSalida;

  public int tipoRequerimientoCantNiveles;

  public String tipoRequerimientoDenominacion;

  public List<Sector> tipoRequerimientoAprueban = new ArrayList<Sector>();

  public List<Empleado> tipoRequerimientoAprobadores = new ArrayList<Empleado>();

}
