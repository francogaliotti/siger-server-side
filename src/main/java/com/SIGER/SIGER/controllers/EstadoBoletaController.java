package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.EstadoBoletaExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.EstadoBoleta;
import com.SIGER.SIGER.model.requests.EstadoBoletaRequest;
import com.SIGER.SIGER.model.responses.EstadoBoletaResponse;
import com.SIGER.SIGER.services.EstadoBoletaService;
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
@RequestMapping("/estado-boleta")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoBoletaController extends
    AbsBaseController<EstadoBoleta, EstadoBoletaService, EstadoBoletaRequest,
        EstadoBoletaResponse, EstadoBoletaExpert> {

  @Autowired
  EstadoBoletaExpert estadoBoletaExpert;


  @Override
  @GetMapping("/")
  public ResponseEntity<List<EstadoBoletaResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return estadoBoletaExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<EstadoBoletaResponse> getById(@PathVariable("id") Long id)
      throws Exception {
    return estadoBoletaExpert.findById(id);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<EstadoBoletaResponse> post(
      @RequestBody EstadoBoletaRequest estadoBoletaRequest)
      throws Exception {
    return estadoBoletaExpert.save(estadoBoletaRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<EstadoBoletaResponse> put(@PathVariable("id") Long id,
      @RequestBody EstadoBoletaRequest estadoBoletaRequest)
      throws Exception {
    return estadoBoletaExpert.update(id, estadoBoletaRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
    return estadoBoletaExpert.delete(id);
  }

}
