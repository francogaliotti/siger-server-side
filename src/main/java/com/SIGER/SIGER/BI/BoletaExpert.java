package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.model.entities.Boleta;
import com.SIGER.SIGER.model.requests.BoletaRequest;
import com.SIGER.SIGER.model.responses.BoletaResponse;
import com.SIGER.SIGER.services.BoletaService;
import org.springframework.stereotype.Component;

@Component
public class BoletaExpert extends
    AbsBaseExpert<Boleta, BoletaService, BoletaRequest, BoletaResponse> {

}
