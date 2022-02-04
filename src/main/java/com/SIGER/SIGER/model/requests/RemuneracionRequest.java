package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.common.ValidationMessages;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemuneracionRequest extends BaseRequest{

  @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
  @Size(max = 250, message = ValidationMessages.REQUEST_PARAM_MAX_ERROR_MESSAGE)
  private String denominacion;

  @PositiveOrZero(message = ValidationMessages.REQUEST_POSITIVE_OR_ZERO_ERROR_MESSAGE)
  private double valorHora;

  @PositiveOrZero(message = ValidationMessages.REQUEST_POSITIVE_OR_ZERO_ERROR_MESSAGE)
  private double valorViaticoDia;

  @PositiveOrZero(message = ValidationMessages.REQUEST_POSITIVE_OR_ZERO_ERROR_MESSAGE)
  private double importeHorasAdicionales;

  @PositiveOrZero(message = ValidationMessages.REQUEST_POSITIVE_OR_ZERO_ERROR_MESSAGE)
  private double importeZonaDesarraigo;

}
