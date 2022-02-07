package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.RemuneracionExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Remuneracion;
import com.SIGER.SIGER.model.requests.RemuneracionRequest;
import com.SIGER.SIGER.model.responses.RemuneracionResponse;
import com.SIGER.SIGER.services.RemuneracionService;
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
@RequestMapping("/remuneracion")
@CrossOrigin(origins = "http://localhost:4200")
public class RemuneracionController extends
    AbsBaseController<Remuneracion, RemuneracionService, RemuneracionRequest, RemuneracionResponse, RemuneracionExpert> {

  @Autowired
  RemuneracionExpert remuneracionExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<RemuneracionResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return remuneracionExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @GetMapping("/list")
  public ResponseEntity<List<RemuneracionResponse>> getListAll() throws Exception {
    return remuneracionExpert.findAll();
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<RemuneracionResponse> getById(@PathVariable("id") Long id)
      throws Exception {
    return remuneracionExpert.findById(id);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<RemuneracionResponse> post(
      @RequestBody RemuneracionRequest remuneracionRequest)
      throws Exception {
    return remuneracionExpert.save(remuneracionRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<RemuneracionResponse> put(@PathVariable("id") Long id,
      @RequestBody RemuneracionRequest remuneracionRequest)
      throws Exception {
    return remuneracionExpert.update(id, remuneracionRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
    return remuneracionExpert.delete(id);
  }

}
