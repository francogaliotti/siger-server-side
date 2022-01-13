package com.SIGER.SIGER.model.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class HistorialSectorEmpleadoRequest extends BaseRequest{
    private Date fechaIngreso;

    private Date fechaSalida;

    private boolean vigente;

    private SectorRequest sector;
}
