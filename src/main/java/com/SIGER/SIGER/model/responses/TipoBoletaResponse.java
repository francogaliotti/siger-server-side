package com.SIGER.SIGER.model.responses;

import com.SIGER.SIGER.model.entities.Empleado;
import com.SIGER.SIGER.model.entities.Sector;
import com.fasterxml.jackson.annotation.JsonRootName;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonRootName("TipoBoleta")
@Getter
@Setter
public class TipoBoletaResponse extends BaseResponse{

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

  public List<Sector> tipoRequerimientoAprueban = new ArrayList<>();

  public List<Empleado> tipoRequerimientoAprobadores = new ArrayList<>();

}
