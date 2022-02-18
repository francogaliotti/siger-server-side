package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.MovilidadExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Movilidad;
import com.SIGER.SIGER.model.requests.MovilidadRequest;
import com.SIGER.SIGER.model.responses.MovilidadResponse;
import com.SIGER.SIGER.services.MovilidadService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/movilidad")
@CrossOrigin
public class MovilidadController extends
    AbsBaseController<Movilidad, MovilidadService, MovilidadRequest, MovilidadResponse, MovilidadExpert> {

  @Autowired
  MovilidadExpert movilidadExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<MovilidadResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return movilidadExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<MovilidadResponse> getById(@PathVariable("id") Long id)
      throws Exception {
    return movilidadExpert.findById(id);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<MovilidadResponse> post(
      @RequestBody MovilidadRequest movilidadRequest)
      throws Exception {
    return movilidadExpert.save(movilidadRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<MovilidadResponse> put(@PathVariable("id") Long id,
      @RequestBody MovilidadRequest movilidadRequest)
      throws Exception {
    return movilidadExpert.update(id, movilidadRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
    return movilidadExpert.delete(id);
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/alreadyExistPatente/{patente}")
  public ResponseEntity<Boolean> alreadyExistByPatente(@PathVariable("patente") String patente){
    return new ResponseEntity<Boolean>(movilidadExpert.alreadyExistByPatente(patente), HttpStatus.OK);
  }

}
