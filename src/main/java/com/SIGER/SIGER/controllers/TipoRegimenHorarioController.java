package com.SIGER.SIGER.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SIGER.SIGER.entities.TipoRegimenHorario;
import com.SIGER.SIGER.services.TipoRegimenHorarioServiceImpl;

@RestController
@RequestMapping("/tipo-regimen-horario")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoRegimenHorarioController extends BaseControllerImpl<TipoRegimenHorario, TipoRegimenHorarioServiceImpl>{
	
	@Autowired
    TipoRegimenHorarioServiceImpl turnoLaboralServiceImpl;

	@Override
	public ResponseEntity<?> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> save(TipoRegimenHorario entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> update(Long id, TipoRegimenHorario entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}