package com.SIGER.SIGER.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TipoBoletaDTO {

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
