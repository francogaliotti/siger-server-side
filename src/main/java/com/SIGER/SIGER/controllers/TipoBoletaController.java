package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.TipoBoletaExpert;
import com.SIGER.SIGER.dto.TipoBoletaDTO;
import com.SIGER.SIGER.entities.TipoBoleta;
import com.SIGER.SIGER.servicesImpl.TipoBoletaServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipoBoleta")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoBoletaController /*extends BaseControllerImpl<TipoBoleta, TipoBoletaServiceImpl>*/{

	@Autowired
	TipoBoletaExpert tipoBoletaExpert;

	//@Override
	@GetMapping("/list")
	public ResponseEntity<List<TipoBoleta>> getAll() {
		return tipoBoletaExpert.getAll();
	}

	//@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") Long id) {
		return tipoBoletaExpert.getOne(id);
	}

	//@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> save(@RequestBody TipoBoletaDTO tipoBoletaDTO) {
		System.out.println(tipoBoletaDTO.getCodigo());
		System.out.println(tipoBoletaDTO.getTipoBoletaDenominacion());
		return tipoBoletaExpert.save(tipoBoletaDTO);
	}

	//@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody TipoBoletaDTO tipoBoletaDTO) {
		return tipoBoletaExpert.update(id, tipoBoletaDTO);
	}

	//@Override
	//@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return tipoBoletaExpert.delete(id);
	}

}

