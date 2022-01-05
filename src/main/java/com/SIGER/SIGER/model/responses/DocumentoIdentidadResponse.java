package com.SIGER.SIGER.model.responses;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

@JsonRootName("DocumentoIdentidad")
@Getter
@Setter
public class DocumentoIdentidadResponse extends BaseResponse {
    private String nroIdentidad;

    private TipoDocumentoResponse tipoDocumento;
}
