package com.SIGER.SIGER.model.requests;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoMovilidadRequest extends BaseRequest{

  private Date fechaAlta;

  private Date fechaBaja;

  private String codigo;

  private String denominacion;

}
