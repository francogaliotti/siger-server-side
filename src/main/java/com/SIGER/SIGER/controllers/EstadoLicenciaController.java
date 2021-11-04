package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.EstadoLicenciaExpert;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.SIGER.SIGER.entities.EstadoLicencia;
import com.SIGER.SIGER.servicesImpl.EstadoLicenciaServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/estadoLicencia")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoLicenciaController extends BaseControllerImpl<EstadoLicencia, EstadoLicenciaServiceImpl>{
	
	@Autowired
	EstadoLicenciaExpert estadoLicenciaExpert;

	@Override
	@GetMapping("/list")
	public ResponseEntity<?> getAll() {
		return estadoLicenciaExpert.getAll();
	}

	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		return  null;
	}

	@Override
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getOne(Long id) {
		return estadoLicenciaExpert.getOne(id);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> save(EstadoLicencia estadoLicencia) {
		return estadoLicenciaExpert.save(estadoLicencia);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, EstadoLicencia estadoLicencia) {
		return estadoLicenciaExpert.update(id, estadoLicencia);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
		return estadoLicenciaExpert.delete(id);
	}
}
