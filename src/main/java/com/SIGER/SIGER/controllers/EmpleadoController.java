package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.EmpleadoExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Empleado;
import com.SIGER.SIGER.model.requests.EmpleadoRequest;
import com.SIGER.SIGER.model.responses.EmpleadoResponse;
import com.SIGER.SIGER.services.EmpleadoService;
import java.sql.SQLTimeoutException;
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
@RequestMapping("/empleado")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController extends
    AbsBaseController<Empleado, EmpleadoService, EmpleadoRequest, EmpleadoResponse, EmpleadoExpert> {

  @Autowired
  EmpleadoExpert empleadoExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<EmpleadoResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return empleadoExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<EmpleadoResponse> getById(@PathVariable Long id) throws Exception {
    return empleadoExpert.findById(id);
  }

  @GetMapping("/employee/{username}")
  public ResponseEntity<EmpleadoResponse> getByUserName(@PathVariable String username) throws Exception {
    return empleadoExpert.getByUserName(username);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<EmpleadoResponse> post(@RequestBody EmpleadoRequest empleadoRequest)
      throws Exception {
    return this.createUsuario(empleadoRequest);
  }

  private ResponseEntity<EmpleadoResponse> createUsuario(EmpleadoRequest empleadoRequest) throws Exception {
    HttpStatus status;
    String message = "";
    empleadoExpert.save(empleadoRequest);

    try{
      empleadoExpert.createUser(empleadoRequest);
      status = HttpStatus.OK;
    }catch (NullPointerException ex){
      status = HttpStatus.BAD_REQUEST;
    }catch (SQLTimeoutException ex){
      status = HttpStatus.REQUEST_TIMEOUT;
    }catch (Exception ex){
      status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    return new ResponseEntity(message, status);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<EmpleadoResponse> put(@PathVariable Long id, @RequestBody EmpleadoRequest empleadoRequest)
      throws Exception {
    return empleadoExpert.update(id, empleadoRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
    return empleadoExpert.delete(id);
  }

}
