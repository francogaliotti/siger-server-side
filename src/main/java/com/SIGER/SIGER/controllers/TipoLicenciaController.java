package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.TipoLicenciaExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.TipoLicencia;
import com.SIGER.SIGER.model.requests.TipoLicenciaRequest;
import com.SIGER.SIGER.model.responses.TipoLicenciaResponse;
import com.SIGER.SIGER.services.TipoLicenciaService;
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
@RequestMapping("/tipo-licencia")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoLicenciaController extends
    AbsBaseController<TipoLicencia, TipoLicenciaService, TipoLicenciaRequest, TipoLicenciaResponse, TipoLicenciaExpert> {

  @Autowired
  TipoLicenciaExpert tipoLicenciaExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<TipoLicenciaResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return tipoLicenciaExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<TipoLicenciaResponse> getById(@PathVariable("id") Long id) throws Exception {
    return tipoLicenciaExpert.findById(id);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<TipoLicenciaResponse> post(@RequestBody TipoLicenciaRequest tipoLicenciaRequest) throws Exception {
    return tipoLicenciaExpert.save(tipoLicenciaRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<TipoLicenciaResponse> put(@PathVariable("id") Long id,
      @RequestBody TipoLicenciaRequest tipoLicenciaRequest) throws Exception {
    return tipoLicenciaExpert.update(id, tipoLicenciaRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
    return tipoLicenciaExpert.delete(id);
  }
}
