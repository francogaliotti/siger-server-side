package com.SIGER.SIGER.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SIGER.SIGER.entities.Remuneracion;
import com.SIGER.SIGER.services.RemuneracionServiceImpl;

@RestController
@RequestMapping
@CrossOrigin
public class RemuneracionController extends BaseControllerImpl<Remuneracion, RemuneracionServiceImpl>{
	
	@Autowired
	RemuneracionServiceImpl remuneracionServiceImpl;

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
	public ResponseEntity<?> save(Remuneracion entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> update(Long id, Remuneracion entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}