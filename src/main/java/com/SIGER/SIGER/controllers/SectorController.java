package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.SectorExpert;
import com.SIGER.SIGER.entities.Sector;
import com.SIGER.SIGER.servicesImpl.SectorServiceImpl;
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
@RequestMapping("/sector")
@CrossOrigin(origins = "http://localhost:4200")
public class SectorController extends BaseControllerImpl<Sector, SectorServiceImpl>{

	@Autowired
	SectorExpert sectorExpert;

	@Override
	@GetMapping("/list")
	public ResponseEntity<?> getAll() {
		return sectorExpert.getAll();
	}

	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getOne(Long id) {
		return sectorExpert.getOne(id);
	}

	/*@GetMapping("/detailname/{nombre}")
	public ResponseEntity<Sector> getByNombre(@PathVariable("nombre") String denominacion){
		return sectorExpert.getByNombre(denominacion);
	}*/

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> save(Sector sector) {
		return sectorExpert.save(sector);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, Sector sector) {
		return sectorExpert.update(id, sector);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
		return sectorExpert.delete(id);
	}

}
