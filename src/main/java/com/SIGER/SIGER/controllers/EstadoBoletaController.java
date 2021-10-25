package com.SIGER.SIGER.controllers;

import java.util.List;

import com.SIGER.SIGER.BI.EstadoBoletaExpert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.entities.EstadoBoleta;
import com.SIGER.SIGER.servicesImpl.EstadoBoletaServiceImpl;

@RestController
@RequestMapping("/estadoBoleta")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoBoletaController extends BaseControllerImpl<EstadoBoleta, EstadoBoletaServiceImpl>{
	
	@Autowired
	EstadoBoletaExpert estadoBoletaExpert;
	
	@Override
	@GetMapping("/list")
	public ResponseEntity<List<EstadoBoleta>> getAll() {
		return estadoBoletaExpert.getAll();
	}
		
	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getOne(Long id) {
		return estadoBoletaExpert.getOne(id);
	}

	@GetMapping("/detailname/{nombre}")
	public ResponseEntity<EstadoBoleta> getByNombre(@PathVariable("nombre") String nombreEstadoBoleta){
		return estadoBoletaExpert.getByNombre(nombreEstadoBoleta);
	}

	@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> save(EstadoBoleta estadoBoleta) {
		return estadoBoletaExpert.save(estadoBoleta);
	}

	@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, EstadoBoleta estadoBoleta) {
		return estadoBoletaExpert.update(id, estadoBoleta);
	}

	@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
		return estadoBoletaExpert.delete(id);
	}

}
