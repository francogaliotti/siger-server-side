package com.SIGER.SIGER.controllers;


import com.SIGER.SIGER.presentation.dto.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.SIGER.SIGER.entities.ZonaInhospita;
import com.SIGER.SIGER.servicesImpl.ZonaInhospitaServiceImpl;

import java.util.List;

@RestController
@RequestMapping("zonaInhospita")
@CrossOrigin(origins = "http://localhost:4200")
public class ZonaInhospitaController extends BaseControllerImpl<ZonaInhospita, ZonaInhospitaServiceImpl>{
	
	@Autowired
	ZonaInhospitaServiceImpl zonaInhospitaServiceImpl ;

	@Override
	@GetMapping("/list")
	public ResponseEntity<?> getAll() {
		List<ZonaInhospita> list = null;
		try{
			list = zonaInhospitaServiceImpl.FindAll();
		}catch (Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		List<ZonaInhospita> zonaInhospitas = null;
		try {
			zonaInhospitas = zonaInhospitaServiceImpl.FindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(zonaInhospitas, HttpStatus.OK);
	}

	@Override
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getOne(Long id) {
		try {
			if(zonaInhospitaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ZonaInhospita zonaInhospita = null;

		try{
			zonaInhospita = zonaInhospitaServiceImpl.FindById(id);
		} catch (Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity(zonaInhospita, HttpStatus.OK);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> save(ZonaInhospita zonaInhospita) {
		try{
			zonaInhospita = zonaInhospitaServiceImpl.Save(zonaInhospita);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Zona Inhóspita creada"), HttpStatus.OK);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, ZonaInhospita zonaInhospita) {
		try {
			if(zonaInhospitaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(StringUtils.isBlank(zonaInhospita.getDenominacionZona()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(zonaInhospita.getCodZona().length()<0)
			return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

		try {
			zonaInhospitaServiceImpl.Update(id, zonaInhospita);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Zona Inhóspita actualizada"), HttpStatus.OK);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
		try {
			if(zonaInhospitaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			zonaInhospitaServiceImpl.Delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Zona Inhóspita eliminada"), HttpStatus.OK);
	}

}
