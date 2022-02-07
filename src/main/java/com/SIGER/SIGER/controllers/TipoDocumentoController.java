package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.model.entities.TipoDocumento;
import com.SIGER.SIGER.model.responses.TipoDocumentoResponse;
import com.SIGER.SIGER.repositories.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tipo-documento")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoDocumentoController {

    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;


    @GetMapping("/")
    public ResponseEntity<List<TipoDocumentoResponse>> getAll() throws Exception {
        List<TipoDocumento> tipoDocumentos = tipoDocumentoRepository.findAll();
        List<TipoDocumentoResponse> tipoDocumentoResponses = new ArrayList<>();
        for (int i=0; i < tipoDocumentos.size(); i++){
            TipoDocumentoResponse tipoDocumentoResponse = new TipoDocumentoResponse();
            tipoDocumentoResponse.setTipoDocumento(tipoDocumentos.get(i).getTipoDocumento());
            tipoDocumentoResponse.setId(tipoDocumentos.get(i).getId());
            tipoDocumentoResponses.add(tipoDocumentoResponse);
        }
        return new ResponseEntity<>(tipoDocumentoResponses, HttpStatus.OK);
    }
}
