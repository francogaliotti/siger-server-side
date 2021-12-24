package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.ViaticoExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Viatico;
import com.SIGER.SIGER.model.requests.ViaticoRequest;
import com.SIGER.SIGER.model.responses.ViaticoResponse;
import com.SIGER.SIGER.services.ViaticoService;
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
@RequestMapping("/viatico")
@CrossOrigin(origins = "http://localhost:4200")
public class ViaticoController extends
    AbsBaseController<Viatico, ViaticoService, ViaticoRequest, ViaticoResponse, ViaticoExpert> {

  @Autowired
  ViaticoExpert viaticoExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<ViaticoResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return viaticoExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<ViaticoResponse> getById(@PathVariable Long id) throws Exception {
    return viaticoExpert.findById(id);
  }

	/*@GetMapping("/detailname/{nombre}")
	public ResponseEntity<Viatico> getByNombre(@PathVariable("nombre") String denominacionViatico){
		return viaticoExpert.getByNombre(denominacionViatico);
	}*/

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<ViaticoResponse> post(@RequestBody ViaticoRequest viaticoRequest) throws Exception {
    return viaticoExpert.save(viaticoRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<ViaticoResponse> put(@PathVariable Long id, @RequestBody ViaticoRequest viaticoRequest)
      throws Exception {
    return viaticoExpert.update(id, viaticoRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
    return viaticoExpert.delete(id);
  }

}
