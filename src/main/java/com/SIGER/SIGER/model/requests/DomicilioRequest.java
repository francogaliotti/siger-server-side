package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.datos_gob_ar.entities.Localidad;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomicilioRequest extends BaseRequest {
    private String calle;
    private int nroCalle;
    private String departamento;
    private int nroPiso;
    private String barrio;
    private String manzana;
    private String casa;
    private Localidad localidad;
}
