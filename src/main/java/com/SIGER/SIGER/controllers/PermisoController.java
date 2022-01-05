package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.PermisoExpert;
import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Permiso;
import com.SIGER.SIGER.model.requests.PermisoRequest;
import com.SIGER.SIGER.model.responses.PermisoResponse;
import com.SIGER.SIGER.services.PermisoService;
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
@RequestMapping("/permiso")
@CrossOrigin(origins = "http://localhost:4200")
public class PermisoController extends
    AbsBaseController<Permiso, PermisoService, PermisoRequest, PermisoResponse, PermisoExpert> {

  @Autowired
  PermisoExpert permisoExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<PermisoResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return permisoExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

    /*@GetMapping("/detail-name/{nombre}")
    public ResponseEntity<Permiso> getByNombre(@PathVariable("nombre") String nombrePermiso){
        if(!permisoServiceImpl.existByNombrePermiso(nombrePermiso))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Permiso permiso = permisoServiceImpl.getByNombrePermiso(nombrePermiso).get();
        return new ResponseEntity(permiso, HttpStatus.OK);
    }*/

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<PermisoResponse> getById(@PathVariable("id") Long id) throws Exception {
    return permisoExpert.findById(id);
  }

  @Override
  @PostMapping("/")
  public ResponseEntity<PermisoResponse> post(@RequestBody PermisoRequest permisoRequest) throws Exception {
    return permisoExpert.save(permisoRequest);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<PermisoResponse> put(@PathVariable("id") Long id, @RequestBody PermisoRequest permisoRequest)
      throws Exception {
    return permisoExpert.update(id, permisoRequest);
  }


  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
    permisoExpert.delete(id);
    return new ResponseEntity(new Message("Permiso eliminado"), HttpStatus.OK);
  }
}
