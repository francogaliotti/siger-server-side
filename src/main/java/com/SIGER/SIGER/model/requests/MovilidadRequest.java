package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.common.ValidationMessages;
import com.SIGER.SIGER.model.entities.TipoMovilidad;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovilidadRequest extends BaseRequest {

  private Date fechaAlta;

  private Date fechaBaja;

  @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
  @Size(max = 250, message = ValidationMessages.REQUEST_PARAM_MAX_ERROR_MESSAGE)
  private String codigo;

  @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
  @Size(max = 250, message = ValidationMessages.REQUEST_PARAM_MAX_ERROR_MESSAGE)
  private String patente;

  private TipoMovilidad tipoMovilidad;

}
