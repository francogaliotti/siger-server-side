package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Remuneración")
@Getter
@Setter
public class RemuneracionResponse extends BaseResponse{

  private double valorHora;

  private double valorViaticoDia;

  private double importeHorasAdicionales;

  private double importeZonaDesarraigo;

}
