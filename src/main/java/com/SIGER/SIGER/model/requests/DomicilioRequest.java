package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.datos_gob_ar.requests.DepartamentoRequest;
import com.SIGER.SIGER.datos_gob_ar.requests.LocalidadRequest;
import com.SIGER.SIGER.datos_gob_ar.requests.MunicipioRequest;
import com.SIGER.SIGER.datos_gob_ar.requests.ProvinciaRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomicilioRequest extends BaseRequest {
    private String calle;
    private int nroCalle;
    private String dpto;
    private int nroPiso;
    private String barrio;
    private String manzana;
    private String casa;
    private ProvinciaRequest provincia;
    private DepartamentoRequest departamento;
    private MunicipioRequest municipio;
    private LocalidadRequest localidad;
}
