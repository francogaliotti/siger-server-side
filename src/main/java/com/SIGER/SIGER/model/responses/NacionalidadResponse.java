package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName("Nacionalidad")
@Getter
@Setter
public class NacionalidadResponse extends  BaseResponse{
    private String nombre;
}
