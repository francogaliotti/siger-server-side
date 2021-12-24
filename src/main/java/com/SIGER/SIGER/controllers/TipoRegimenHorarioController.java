package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.TipoRegimenHorarioExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.TipoRegimenHorario;
import com.SIGER.SIGER.model.requests.TipoRegimenHorarioRequest;
import com.SIGER.SIGER.model.responses.TipoRegimenHorarioResponse;
import com.SIGER.SIGER.services.TipoRegimenHorarioService;
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
@RequestMapping("/tipo-regimen-horario")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoRegimenHorarioController extends
    AbsBaseController<TipoRegimenHorario, TipoRegimenHorarioService, TipoRegimenHorarioRequest, TipoRegimenHorarioResponse, TipoRegimenHorarioExpert> {

  @Autowired
  TipoRegimenHorarioExpert tipoRegimenHorarioExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<TipoRegimenHorarioResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return tipoRegimenHorarioExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<TipoRegimenHorarioResponse> getById(@PathVariable("id") Long id)
      throws Exception {
    return tipoRegimenHorarioExpert.findById(id);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<TipoRegimenHorarioResponse> post(
      @RequestBody TipoRegimenHorarioRequest tipoRegimenHorarioRequest)
      throws Exception {
    return tipoRegimenHorarioExpert.save(tipoRegimenHorarioRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<TipoRegimenHorarioResponse> put(@PathVariable("id") Long id,
      @RequestBody TipoRegimenHorarioRequest tipoRegimenHorarioRequest)
      throws Exception {
    return tipoRegimenHorarioExpert.update(id, tipoRegimenHorarioRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
    return tipoRegimenHorarioExpert.delete(id);
  }

}