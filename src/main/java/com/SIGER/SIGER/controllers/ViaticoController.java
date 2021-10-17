package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.ViaticoExpert;
import com.SIGER.SIGER.entities.EstadoBoleta;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.SIGER.SIGER.entities.Viatico;
import com.SIGER.SIGER.servicesImpl.ViaticoServiceImpl;

@RestController
@RequestMapping("/viatico")
@CrossOrigin(origins = "http://localhost:4200")
public class ViaticoController extends BaseControllerImpl<Viatico, ViaticoServiceImpl>{

	@Autowired
	ViaticoExpert viaticoExpert;

	@Override
	@GetMapping("/list")
	public ResponseEntity<?> getAll() {
		return viaticoExpert.getAll();
	}

	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getOne(Long id) {
		return viaticoExpert.getOne(id);
	}

	@GetMapping("/detailname/{nombre}")
	public ResponseEntity<Viatico> getByNombre(@PathVariable("nombre") String denominacionViatico){
		return viaticoExpert.getByNombre(denominacionViatico);
	}

	@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> save(Viatico viatico) {
		return viaticoExpert.save(viatico);
	}

	@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, Viatico viatico) {
		return viaticoExpert.update(id, viatico);
	}

	@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
		return viaticoExpert.delete(id);
	}

}
