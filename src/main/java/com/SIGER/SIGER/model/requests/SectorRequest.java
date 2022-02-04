package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.common.ValidationMessages;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.SIGER.SIGER.model.entities.Domicilio;
import com.SIGER.SIGER.model.entities.Sector;
import com.SIGER.SIGER.model.entities.TipoSector;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectorRequest extends BaseRequest{

  @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
  @Size(max = 250, message = ValidationMessages.REQUEST_PARAM_MAX_ERROR_MESSAGE)
  private String codigo;

  @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
  @Size(max = 250, message = ValidationMessages.REQUEST_PARAM_MAX_ERROR_MESSAGE)
  private String denominacion;

  private Date fechaBaja;

  private boolean validaFueraDeHorario;

  private boolean detenerCargaBoletas;

  private boolean permiteTrabajarHorasExtras;

  private boolean permiteTrabajarFinDeSemana;

  private int maximoSerenoDiurno;

  private int maximoSerenoNocturno;

  private Sector sectorSuperior;

  private TipoSector tipoSector;

  //private Domicilio domicilio;

}
