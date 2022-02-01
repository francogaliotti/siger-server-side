package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.model.entities.TipoDocumento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentoIdentidadRequest extends BaseRequest {
    private String nroIdentidad;

    private TipoDocumento tipoDocumento;
}
