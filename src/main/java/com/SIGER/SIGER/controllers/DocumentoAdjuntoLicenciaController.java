package com.SIGER.SIGER.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SIGER.SIGER.entities.DocumentoAdjuntoLicencia;
import com.SIGER.SIGER.services.DocumentoAdjuntoLicenciaServiceImpl;

@RestController
@RequestMapping
@CrossOrigin
public class DocumentoAdjuntoLicenciaController extends BaseControllerImpl<DocumentoAdjuntoLicencia, DocumentoAdjuntoLicenciaServiceImpl>{
	
	@Autowired
	DocumentoAdjuntoLicenciaServiceImpl documentoAdjuntoLicenciaServiceImpl;

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
	public ResponseEntity<?> save(DocumentoAdjuntoLicencia entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> update(Long id, DocumentoAdjuntoLicencia entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
