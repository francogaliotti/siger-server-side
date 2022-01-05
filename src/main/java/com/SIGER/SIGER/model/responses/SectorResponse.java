package com.SIGER.SIGER.model.responses;

import com.SIGER.SIGER.model.entities.Domicilio;
import com.SIGER.SIGER.model.entities.Sector;
import com.SIGER.SIGER.model.entities.TipoSector;
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

  private boolean validaFueraDeHorario;

  private char detenerCargaBoletas;

  private boolean permiteTrabajarHorasExtras;

  private boolean permiteTrabajarFinDeSemana;

  private int maximoSerenoDiurno;

  private int maximoSerenoNocturno;

  private Sector sectorSuperior;

  private TipoSector tipoSector;

  //private Domicilio domicilio;

}
