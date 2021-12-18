package com.SIGER.SIGER.model.requests;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

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

}
