package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@JsonRootName("HistorialSectorEmpleado")
@Getter
@Setter
public class HistorialSectorEmpleadoResponse extends BaseResponse  {
    private Date fechaIngreso;

    private Date fechaSalida;

    private boolean vigente;

    private SectorResponse sector;
}
