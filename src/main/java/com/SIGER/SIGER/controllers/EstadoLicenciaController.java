package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.EstadoLicenciaExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.EstadoLicencia;
import com.SIGER.SIGER.model.requests.EstadoLicenciaRequest;
import com.SIGER.SIGER.model.responses.EstadoLicenciaResponse;
import com.SIGER.SIGER.services.EstadoLicenciaService;
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
@RequestMapping("/estado-licencia")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoLicenciaController extends
    AbsBaseController<EstadoLicencia, EstadoLicenciaService, EstadoLicenciaRequest, EstadoLicenciaResponse, EstadoLicenciaExpert> {

  @Autowired
  EstadoLicenciaExpert estadoLicenciaExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<EstadoLicenciaResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return estadoLicenciaExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<EstadoLicenciaResponse> getById(@PathVariable Long id) {
    return estadoLicenciaExpert.findById(id);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<EstadoLicenciaResponse> post(@RequestBody EstadoLicenciaRequest estadoLicenciaRequest)
      throws Exception {
    return estadoLicenciaExpert.save(estadoLicenciaRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<EstadoLicenciaResponse> put(@PathVariable Long id,
      @RequestBody EstadoLicenciaRequest estadoLicenciaRequest)
      throws Exception {
    return estadoLicenciaExpert.update(id, estadoLicenciaRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
    return estadoLicenciaExpert.delete(id);
  }
}
