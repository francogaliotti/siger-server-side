package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.NacionalidadExpert;
import com.SIGER.SIGER.model.requests.BaseRequest;
import com.SIGER.SIGER.model.responses.NacionalidadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/nationality")
@CrossOrigin(origins = "http://localhost:4200")
public class NacionalidadController implements BaseController {

    @Autowired
    private NacionalidadExpert nationalityExpert;

    @Override
    @GetMapping("/")
    public ResponseEntity<List<NacionalidadResponse>> getAll(int page, UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {
        return nationalityExpert.GetAll();
    }

    @Override
    public ResponseEntity getById(Serializable serializable) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity post(BaseRequest baseRequest) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity put(Serializable serializable, BaseRequest baseRequest) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity patch(Serializable serializable, BaseRequest dto) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Serializable serializable) throws Exception {
        return null;
    }
}
