package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.PlanillaExpert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planilla")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanillaController {

    @Autowired
    PlanillaExpert _planilla;


    public ResponseEntity<?> processingSheets(){

        try {
            _planilla.processingSheets();
        }catch (Exception ex){

        }
        return  null;
    }
}
