package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.model.entities.Asistencia;
import com.SIGER.SIGER.model.requests.AsistenciaRequest;
import com.SIGER.SIGER.model.responses.AsistenciaResponse;
import com.SIGER.SIGER.services.AsistenciaService;
import org.springframework.stereotype.Component;

@Component
public class AsistenciaExpert extends
    AbsBaseExpert<Asistencia, AsistenciaService, AsistenciaRequest, AsistenciaResponse> {

}
