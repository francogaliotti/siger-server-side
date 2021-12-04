package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Sector")
@Getter
@Setter
public class SectorResponse extends BaseResponse{

  private String codigo;

  private String denominacion;

  private Date fechaBaja;

  private char validaFueraDeHorario;

  private char detenerCargaBoletas;

  private boolean permiteTrabajarHorasExtras;

  private boolean permiteTrabajarFinDeSemana;

  private int maximoSerenoDiurno;

  private int maximoSerenoNocturno;

}
