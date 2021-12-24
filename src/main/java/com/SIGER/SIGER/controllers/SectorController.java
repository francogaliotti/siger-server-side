package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.SectorExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Sector;
import com.SIGER.SIGER.model.requests.SectorRequest;
import com.SIGER.SIGER.model.responses.SectorResponse;
import com.SIGER.SIGER.services.SectorService;
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
@RequestMapping("/sector")
@CrossOrigin(origins = "http://localhost:4200")
public class SectorController extends
    AbsBaseController<Sector, SectorService, SectorRequest, SectorResponse, SectorExpert> {

  @Autowired
  SectorExpert sectorExpert;

  @Override
  @GetMapping("/")
  public ResponseEntity<List<SectorResponse>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return sectorExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
        response);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<SectorResponse> getById(@PathVariable Long id) throws Exception {
    return sectorExpert.findById(id);
  }

	/*@GetMapping("/detailname/{nombre}")
	public ResponseEntity<Sector> getByNombre(@PathVariable("nombre") String denominacion){
		return sectorExpert.getByNombre(denominacion);
	}*/

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("/")
  public ResponseEntity<SectorResponse> post(@RequestBody SectorRequest sectorRequest) throws Exception {
    return sectorExpert.save(sectorRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{id}")
  public ResponseEntity<SectorResponse> put(@PathVariable Long id, @RequestBody SectorRequest sectorRequest) throws Exception {
    return sectorExpert.update(id, sectorRequest);
  }

  @Override
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
    return sectorExpert.delete(id);
  }

}
