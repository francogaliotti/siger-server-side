package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.LicenciaExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Licencia;
import com.SIGER.SIGER.model.requests.LicenciaRequest;
import com.SIGER.SIGER.model.responses.LicenciaResponse;
import com.SIGER.SIGER.model.responses.SectorResponse;
import com.SIGER.SIGER.services.LicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/licencia")
@CrossOrigin(origins = "http://localhost:4200")
public class LicenciaController extends
        AbsBaseController<Licencia, LicenciaService, LicenciaRequest, LicenciaResponse, LicenciaExpert> {

    @Autowired
    LicenciaExpert licenciaExpert;

    @Override
    @GetMapping("/")
    public ResponseEntity<List<LicenciaResponse>> getAll(@RequestParam("page") int page,
                                                         UriComponentsBuilder uriBuilder,
                                                         HttpServletResponse response) throws Exception {
        return licenciaExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
                response);

    }

    @GetMapping("/list")
    public ResponseEntity<List<LicenciaResponse>> getAll() throws Exception {
        return licenciaExpert.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<LicenciaResponse> getById(@PathVariable("id") Long id) throws Exception {
        return licenciaExpert.findById(id);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<LicenciaResponse> post(@RequestBody LicenciaRequest licenciaRequest) throws Exception {
        return licenciaExpert.save(licenciaRequest);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<LicenciaResponse> put(@PathVariable("id") Long id,
                                                @RequestBody LicenciaRequest licenciaRequest) throws Exception {
        return licenciaExpert.update(id, licenciaRequest);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long id) throws Exception {
        return licenciaExpert.delete(id);
    }

    @PutMapping("/authorize/{id}")
    public ResponseEntity<LicenciaResponse> authorize(@PathVariable Long id) throws Exception {
        return licenciaExpert.authorize(id);
    }

    @PutMapping("/reject/{id}")
    public ResponseEntity<LicenciaResponse> reject(@PathVariable Long id, @RequestBody LicenciaRequest licenciaRequest) throws Exception {
        return licenciaExpert.reject(id, licenciaRequest);
    }


}
