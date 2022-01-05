package com.SIGER.SIGER.model.responses;

import com.SIGER.SIGER.model.entities.TipoMovilidad;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Movilidad")
@Getter
@Setter
public class MovilidadResponse extends BaseResponse {

  private Date fechaAlta;

  private Date fechaBaja;

  private String codigo;

  private String patente;

  private TipoMovilidad tipoMovilidad;


}
