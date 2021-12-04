package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.AsistenciaExpert;
import com.SIGER.SIGER.model.entities.Asistencia;
import com.SIGER.SIGER.model.requests.AsistenciaRequest;
import com.SIGER.SIGER.model.responses.AsistenciaResponse;
import com.SIGER.SIGER.services.AsistenciaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asistencia")
@CrossOrigin(origins = "http://localhost:4200")
public class AsistenciaController extends
    AbsBaseController<Asistencia, AsistenciaService, AsistenciaRequest, AsistenciaResponse,
            AsistenciaExpert> {

}
