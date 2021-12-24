package com.SIGER.SIGER.controllers;


import com.SIGER.SIGER.BI.ZonaInhospitaExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.ZonaInhospita;
import com.SIGER.SIGER.model.requests.ZonaInhospitaRequest;
import com.SIGER.SIGER.model.responses.ZonaInhospitaResponse;
import com.SIGER.SIGER.services.ZonaInhospitaService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/zona-inhospita")
@CrossOrigin(origins = "http://localhost:4200")
public class ZonaInhospitaController extends
    AbsBaseController<ZonaInhospita, ZonaInhospitaService, ZonaInhospitaRequest, ZonaInhospitaResponse, ZonaInhospitaExpert> {

  @Autowired
  ZonaInhospitaExpert zonaInhospitaExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<ZonaInhospitaResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return zonaInhospitaExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<ZonaInhospitaResponse> getById(@PathVariable Long id) throws Exception {
    return zonaInhospitaExpert.findById(id);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<ZonaInhospitaResponse> post(
      @RequestBody ZonaInhospitaRequest zonaInhospitaRequest)
      throws Exception {
    return zonaInhospitaExpert.save(zonaInhospitaRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<ZonaInhospitaResponse> put(@PathVariable Long id,
      @RequestBody ZonaInhospitaRequest zonaInhospitaRequest)
      throws Exception {
    return zonaInhospitaExpert.update(id, zonaInhospitaRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
    return zonaInhospitaExpert.delete(id);
  }

}
