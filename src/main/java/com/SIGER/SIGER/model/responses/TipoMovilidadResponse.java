package com.SIGER.SIGER.model.responses;

import com.SIGER.SIGER.common.ValidationMessages;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Tipo Movilidad")
@Getter
@Setter
public class TipoMovilidadResponse extends BaseResponse{

  private Date fechaAlta;

  private Date fechaBaja;

  private String codigo;

  private String denominacion;

}
