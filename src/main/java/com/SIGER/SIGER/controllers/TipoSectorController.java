package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.TipoSectorExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.TipoSector;
import com.SIGER.SIGER.model.requests.TipoSectorRequest;
import com.SIGER.SIGER.model.responses.TipoSectorResponse;
import com.SIGER.SIGER.services.TipoSectorService;
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
@RequestMapping("/estado-sector")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoSectorController extends
    AbsBaseController<TipoSector, TipoSectorService, TipoSectorRequest, TipoSectorResponse, TipoSectorExpert> {

  @Autowired
  TipoSectorExpert tipoSectorExpert;

  @Override
  @GetMapping("/list")
  public ResponseEntity<List<TipoSectorResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return tipoSectorExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<TipoSectorResponse> getById(@PathVariable Long id) throws Exception {
    return tipoSectorExpert.findById(id);
  }

	/*@GetMapping("/detailname/{nombre}")
	public ResponseEntity<TipoSector> getByNombreTipoSector(@PathVariable("nombreTipoSector") String nombreTipoSector){
		return tipoSectorExpert.getByNombreTipoSector(nombreTipoSector);
	}*/

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<TipoSectorResponse> post(@RequestBody TipoSectorRequest tipoSectorRequest)
      throws Exception {
    return tipoSectorExpert.save(tipoSectorRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/update/{id}")
  public ResponseEntity<TipoSectorResponse> put(@PathVariable Long id,
      @RequestBody TipoSectorRequest tipoSectorRequest)
      throws Exception {
    return tipoSectorExpert.update(id, tipoSectorRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
    return tipoSectorExpert.delete(id);
  }

}
