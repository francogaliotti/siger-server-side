package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.TipoBoletaExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.TipoBoleta;
import com.SIGER.SIGER.model.requests.TipoBoletaRequest;
import com.SIGER.SIGER.model.responses.TipoBoletaResponse;
import com.SIGER.SIGER.services.TipoBoletaService;
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
@RequestMapping("/tipo-boleta")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoBoletaController extends
    AbsBaseController<TipoBoleta, TipoBoletaService, TipoBoletaRequest, TipoBoletaResponse, TipoBoletaExpert> {

  @Autowired
  TipoBoletaExpert tipoBoletaExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<TipoBoletaResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return tipoBoletaExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<TipoBoletaResponse> getById(@PathVariable("id") Long id) throws Exception {
    return tipoBoletaExpert.findById(id);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<TipoBoletaResponse> post(@RequestBody TipoBoletaRequest tipoBoletaRequest)
      throws Exception {
    return tipoBoletaExpert.save(tipoBoletaRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<TipoBoletaResponse> put(@PathVariable("id") Long id,
      @RequestBody TipoBoletaRequest tipoBoletaRequest) throws Exception {
    return tipoBoletaExpert.update(id, tipoBoletaRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
    return tipoBoletaExpert.delete(id);
  }

}

