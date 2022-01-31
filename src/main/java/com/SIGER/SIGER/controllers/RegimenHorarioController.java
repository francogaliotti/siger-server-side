package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.RegimenHorarioExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.RegimenHorario;
import com.SIGER.SIGER.model.requests.RegimenHorarioRequest;
import com.SIGER.SIGER.model.responses.RegimenHorarioResponse;
import com.SIGER.SIGER.services.RegimenHorarioService;
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
@RequestMapping("/regimen-horario")
@CrossOrigin(origins = "http://localhost:4200")
public class RegimenHorarioController extends
    AbsBaseController<RegimenHorario, RegimenHorarioService, RegimenHorarioRequest, RegimenHorarioResponse, RegimenHorarioExpert> {

  @Autowired
  RegimenHorarioExpert regimenHorarioExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<RegimenHorarioResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return regimenHorarioExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @GetMapping("/list")
  public ResponseEntity<List<RegimenHorarioResponse>> getListAll() throws Exception {
    return regimenHorarioExpert.findAll();
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<RegimenHorarioResponse> getById(@PathVariable("id") Long id)
      throws Exception {
    return regimenHorarioExpert.findById(id);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<RegimenHorarioResponse> post(
      @RequestBody RegimenHorarioRequest regimenHorarioRequest)
      throws Exception {
    return regimenHorarioExpert.save(regimenHorarioRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<RegimenHorarioResponse> put(@PathVariable("id") Long id,
      @RequestBody RegimenHorarioRequest regimenHorarioRequest)
      throws Exception {
    return regimenHorarioExpert.update(id, regimenHorarioRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
    return regimenHorarioExpert.delete(id);
  }
}
