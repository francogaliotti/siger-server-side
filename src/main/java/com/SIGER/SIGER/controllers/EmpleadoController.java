package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.EmpleadoExpert;
import com.SIGER.SIGER.entities.Empleado;
import com.SIGER.SIGER.servicesImpl.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoServiceImpl>{

	@Autowired
	EmpleadoExpert empleadoExpert;

	@Override
	@GetMapping("/list")
	public ResponseEntity<?> getAll() {
		return empleadoExpert.getAll();
	}

	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		return null;
	}

	@Override
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getOne(Long id) {
		return empleadoExpert.getOne(id);
	}

	/*@GetMapping("/detailname/{nombre}")
	public ResponseEntity<Empleado> getByNombre(@PathVariable("nombre") String nombre){
		return empleadoExpert.getByNombre(nombre);
	}*/

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> save(Empleado empleado) {
		return empleadoExpert.save(empleado);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, Empleado empleado) {
		return empleadoExpert.update(id, empleado);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
		return empleadoExpert.delete(id);
	}

}
