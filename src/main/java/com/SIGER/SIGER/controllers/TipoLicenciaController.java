package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.TipoLicenciaExpert;
import com.SIGER.SIGER.entities.Empleado;
import com.SIGER.SIGER.entities.TipoRequerimiento;
import com.SIGER.SIGER.presentation.dto.LicenciaDTO;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.dto.TipoLicenciaDTO;
import com.SIGER.SIGER.servicesImpl.*;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.SIGER.SIGER.entities.TipoLicencia;

import java.util.List;

@RestController
@RequestMapping("/tipoLicencia")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoLicenciaController /*extends BaseControllerImpl<TipoLicencia, TipoLicenciaServiceImpl>*/{

	@Autowired
	TipoLicenciaExpert tipoLicenciaExpert;


	@GetMapping("/list")
	public ResponseEntity<?> getAll() {
		return tipoLicenciaExpert.getAll();
	}


	public ResponseEntity<?> getAll(Pageable pageable) {
		return null;
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") Long id) {
		return tipoLicenciaExpert.getOne(id);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> save(@RequestBody TipoLicenciaDTO tipoLicenciaDTO) throws Exception {
		return tipoLicenciaExpert.save(tipoLicenciaDTO);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody TipoLicenciaDTO tipoLicenciaDTO) {
		return tipoLicenciaExpert.update(id,tipoLicenciaDTO);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return tipoLicenciaExpert.delete(id);
	}
}
