package com.SIGER.SIGER.controllers;


import com.SIGER.SIGER.BI.ZonaInhospitaExpert;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.SIGER.SIGER.entities.ZonaInhospita;
import com.SIGER.SIGER.servicesImpl.ZonaInhospitaServiceImpl;

import java.util.List;

@RestController
@RequestMapping("zonaInhospita")
@CrossOrigin(origins = "http://localhost:4200")
public class ZonaInhospitaController extends BaseControllerImpl<ZonaInhospita, ZonaInhospitaServiceImpl>{
	
	@Autowired
	ZonaInhospitaExpert zonaInhospitaExpert;

	@Override
	@GetMapping("/list")
	public ResponseEntity<?> getAll() {
		return zonaInhospitaExpert.getAll();
	}

	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		return zonaInhospitaExpert.getAll(pageable);
	}

	@Override
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getOne(Long id) {
		return zonaInhospitaExpert.getOne(id);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> save(ZonaInhospita zonaInhospita) {
		return zonaInhospitaExpert.save(zonaInhospita);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, ZonaInhospita zonaInhospita) {
		return zonaInhospitaExpert.update(id, zonaInhospita);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
		return zonaInhospitaExpert.delete(id);
	}

}
