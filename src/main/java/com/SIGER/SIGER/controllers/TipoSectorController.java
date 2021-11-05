package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.TipoSectorExpert;
import com.SIGER.SIGER.entities.TipoSector;
import com.SIGER.SIGER.servicesImpl.TipoSectorServiceImpl;
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
@RequestMapping("/tipoSector")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoSectorController extends BaseControllerImpl<TipoSector, TipoSectorServiceImpl>{
	
	@Autowired
	TipoSectorExpert tipoSectorExpert;

	@Override
	@GetMapping("/list")
	public ResponseEntity<?> getAll() {
		return tipoSectorExpert.getAll();
	}

	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		return null;
	}

	@Override
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getOne(Long id) {
		return tipoSectorExpert.getOne(id);
	}

	/*@GetMapping("/detailname/{nombre}")
	public ResponseEntity<TipoSector> getByNombreTipoSector(@PathVariable("nombreTipoSector") String nombreTipoSector){
		return tipoSectorExpert.getByNombreTipoSector(nombreTipoSector);
	}*/

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> save(TipoSector tipoSector) {
		return tipoSectorExpert.save(tipoSector);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, TipoSector tipoSector) {
		return tipoSectorExpert.update(id, tipoSector);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
		return tipoSectorExpert.delete(id);
	}

}
