package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.AsistenciaExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Asistencia;
import com.SIGER.SIGER.model.requests.AsistenciaRequest;
import com.SIGER.SIGER.model.responses.AsistenciaResponse;
import com.SIGER.SIGER.services.AsistenciaService;
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
@RequestMapping("/asistencia")
@CrossOrigin(origins = "http://localhost:4200")
public class AsistenciaController extends
    AbsBaseController<Asistencia, AsistenciaService, AsistenciaRequest, AsistenciaResponse,
        AsistenciaExpert> {

  @Autowired
  AsistenciaExpert asistenciaExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<AsistenciaResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return asistenciaExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @GetMapping("/mis-asistencias")
  public ResponseEntity<List<AsistenciaResponse>> getAll(@RequestParam("id") long id, @RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return asistenciaExpert.findAllMyAttendances(id,page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<AsistenciaResponse> getById(@PathVariable("id") Long id)
      throws Exception {
    return asistenciaExpert.findById(id);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<AsistenciaResponse> post(
      @RequestBody AsistenciaRequest asistenciaRequest)
      throws Exception {
    return asistenciaExpert.save(asistenciaRequest);
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/csv")
  public ResponseEntity<AsistenciaResponse> attendanceLoading()
      throws Exception {
    return asistenciaExpert.automaticLoad();
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<AsistenciaResponse> put(@PathVariable("id") Long id,
      @RequestBody AsistenciaRequest asistenciaRequest)
      throws Exception {
    return asistenciaExpert.update(id, asistenciaRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
    return asistenciaExpert.delete(id);
  }

}
