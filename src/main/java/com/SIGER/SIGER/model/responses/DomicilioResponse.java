package com.SIGER.SIGER.model.responses;

import com.SIGER.SIGER.datos_gob_ar.entities.Departamento;
import com.SIGER.SIGER.datos_gob_ar.entities.Localidad;
import com.SIGER.SIGER.datos_gob_ar.entities.Provincia;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Domicilio")
@Getter
@Setter
public class DomicilioResponse extends BaseResponse {
    private String calle;
    private int nroCalle;
    private int nroDepartamento;
    private int nroPiso;
    private Localidad localidad;
    private Provincia provincia;
    private Departamento departamento;
}
