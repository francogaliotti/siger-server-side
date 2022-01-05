package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

@JsonRootName("TipoDocumento")
@Getter
@Setter
public class TipoDocumentoResponse extends BaseResponse{
    private String tipoDocumente;
}
