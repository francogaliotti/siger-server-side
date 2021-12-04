package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.ProvinciaExpert;
import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Provincia;
import com.SIGER.SIGER.model.requests.ProvinciaRequest;
import com.SIGER.SIGER.model.responses.ProvinciaResponse;
import com.SIGER.SIGER.services.ProvinciaService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/provincia")
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinciaController extends
    AbsBaseController<Provincia, ProvinciaService, ProvinciaRequest, ProvinciaResponse, ProvinciaExpert> {

  @Autowired
  ProvinciaExpert provinciaExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<ProvinciaResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return provinciaExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  /*@GetMapping("/detail-den/{denomination}")
  public ResponseEntity<Provincia> getByDenominacion(@PathVariable("denominacion") String den) {
    if (!provinciaExpert.existByDenominacion(den)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }
    Provincia provincia = provinciaExpert.getByDenominacion(den).get();
    return new ResponseEntity(provincia, HttpStatus.OK);
  }*/

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<ProvinciaResponse> getById(@PathVariable("id") Long id) throws Exception {
    return provinciaExpert.findById(id);
  }

  @Override
  @PostMapping("/")
  public ResponseEntity<ProvinciaResponse> post(@RequestBody ProvinciaRequest provinciaRequest)
      throws Exception {
    provinciaExpert.save(provinciaRequest);
    return new ResponseEntity(new Message("Provincia creada"), HttpStatus.OK);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<ProvinciaResponse> put(@PathVariable("id") Long id,
      @RequestBody ProvinciaRequest provinciaRequest)
      throws Exception {
    provinciaExpert.save(provinciaRequest);
    return new ResponseEntity(new Message("Provincia actualizada"), HttpStatus.OK);
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
    provinciaExpert.delete(id);
    return new ResponseEntity(new Message("Provincia eliminada"), HttpStatus.OK);
  }
}
