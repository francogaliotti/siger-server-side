package com.SIGER.SIGER.model.responses;

import com.SIGER.SIGER.model.entities.Datos_gob_ar.Localidad;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Domicilio")
@Getter
@Setter
public class DomicilioResponse extends BaseResponse {
    private String calle;
    private int nroCalle;
    private String departamento;
    private int nroPiso;
    private String barrio;
    private String manzana;
    private String casa;
    private Localidad localidad;
}
