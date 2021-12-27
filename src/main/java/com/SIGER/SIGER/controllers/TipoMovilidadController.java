package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.TipoMovilidadExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.TipoMovilidad;
import com.SIGER.SIGER.model.requests.TipoMovilidadRequest;
import com.SIGER.SIGER.model.responses.TipoMovilidadResponse;
import com.SIGER.SIGER.services.TipoMovilidadService;
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
@RequestMapping("/tipo-movilidad")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoMovilidadController extends
    AbsBaseController<TipoMovilidad, TipoMovilidadService, TipoMovilidadRequest, TipoMovilidadResponse, TipoMovilidadExpert> {

  @Autowired
  TipoMovilidadExpert tipoMovilidadExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<TipoMovilidadResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return tipoMovilidadExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<TipoMovilidadResponse> getById(@PathVariable("id") Long id)
      throws Exception {
    return tipoMovilidadExpert.findById(id);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<TipoMovilidadResponse> post(
      @RequestBody TipoMovilidadRequest tipoMovilidadRequest)
      throws Exception {
    return tipoMovilidadExpert.save(tipoMovilidadRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<TipoMovilidadResponse> put(@PathVariable("id") Long id,
      @RequestBody TipoMovilidadRequest tipoMovilidadRequest)
      throws Exception {
    return tipoMovilidadExpert.update(id, tipoMovilidadRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
    return tipoMovilidadExpert.delete(id);
  }

}
