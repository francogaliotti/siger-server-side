package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.common.ValidationMessages;
import javax.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemuneracionRequest extends BaseRequest{

  @PositiveOrZero(message = ValidationMessages.REQUEST_POSITIVE_OR_ZERO_ERROR_MESSAGE)
  private double valorHora;

  @PositiveOrZero(message = ValidationMessages.REQUEST_POSITIVE_OR_ZERO_ERROR_MESSAGE)
  private double valorViaticoDia;

  @PositiveOrZero(message = ValidationMessages.REQUEST_POSITIVE_OR_ZERO_ERROR_MESSAGE)
  private double importeHorasAdicionales;

  @PositiveOrZero(message = ValidationMessages.REQUEST_POSITIVE_OR_ZERO_ERROR_MESSAGE)
  private double importeZonaDesarraigo;

}
