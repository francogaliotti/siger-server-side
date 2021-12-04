/*package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.services.TipoMovilidadService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SIGER.SIGER.model.entities.TipoMovilidad;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/estado_boleta")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoMovilidadController extends
		AbsBaseController<TipoMovilidad, TipoMovilidadService> {
	
	@Autowired
	TipoMovilidadService tipoMovilidadServiceImpl;

	@Override
	public ResponseEntity<?> findAll(@RequestParam("page") int page,
			UriComponentsBuilder uriBuilder,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> save(TipoMovilidad entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> update(Long id, TipoMovilidad entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}*/
