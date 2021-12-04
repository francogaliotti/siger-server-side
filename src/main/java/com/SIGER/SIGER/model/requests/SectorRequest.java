package com.SIGER.SIGER.model.requests;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectorRequest extends BaseRequest{

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
