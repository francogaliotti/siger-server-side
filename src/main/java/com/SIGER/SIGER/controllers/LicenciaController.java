package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.LicenciaExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Licencia;
import com.SIGER.SIGER.model.requests.LicenciaRequest;
import com.SIGER.SIGER.model.responses.LicenciaResponse;
import com.SIGER.SIGER.services.LicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/licencia")
@CrossOrigin(origins = "http://localhost:4200")
public class LicenciaController extends
		AbsBaseController<Licencia, LicenciaService, LicenciaRequest, LicenciaResponse, LicenciaExpert> {

	@Autowired
	LicenciaExpert licenciaExpert;

	@Override
	@GetMapping("/")
	public ResponseEntity<List<LicenciaResponse>> getAll(@RequestParam("page") int page,
															 UriComponentsBuilder uriBuilder,
															 HttpServletResponse response) throws Exception {
		return licenciaExpert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE, uriBuilder,
				response);

	}

	@Override
	public ResponseEntity<LicenciaResponse> getById(@PathVariable("id") Long id) throws Exception {
		return licenciaExpert.findById(id);
	}

	@Override
	@PostMapping("/")
	public ResponseEntity<LicenciaResponse> post(@RequestBody LicenciaRequest licenciaRequest) throws Exception {
		return licenciaExpert.save(licenciaRequest);
	}

	@Override
	public ResponseEntity<LicenciaResponse> put(@PathVariable("id") Long id,
								 @RequestBody LicenciaRequest licenciaRequest) throws Exception {
		// TODO Auto-generated method stub
		return licenciaExpert.update(id, licenciaRequest);
	}

	@Override
	public ResponseEntity<?> delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return licenciaExpert.delete(id);
	}

}
