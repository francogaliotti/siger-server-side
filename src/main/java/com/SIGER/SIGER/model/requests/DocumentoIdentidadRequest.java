package com.SIGER.SIGER.model.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentoIdentidadRequest extends BaseRequest {
    private String nroIdentidad;

    private TipoDocumentoRequest tipoDocumento;
}
