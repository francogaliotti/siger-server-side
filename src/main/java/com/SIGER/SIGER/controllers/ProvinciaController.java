package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.presentation.dto.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.SIGER.SIGER.entities.Provincia;
import com.SIGER.SIGER.services.ProvinciaServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/provincia")
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinciaController extends BaseControllerImpl<Provincia, ProvinciaServiceImpl>{
	
	@Autowired
	ProvinciaServiceImpl provinciaServiceImpl;



	@GetMapping("/list")
	public ResponseEntity<List<Provincia>> getAll(){
		List<Provincia> list= provinciaServiceImpl.list();
		return new ResponseEntity<List<Provincia>>(list, HttpStatus.OK);
	}
	@GetMapping("/detail-den/{denomination}")
	public ResponseEntity<Provincia> getByDenominacion(@PathVariable("denominacion") String den){
		if(!provinciaServiceImpl.existByDenominacion(den))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		Provincia provincia = provinciaServiceImpl.getByDenominacion(den).get();
		return new ResponseEntity(provincia, HttpStatus.OK);
	}
	@GetMapping("/detail/{id}")
	public ResponseEntity<Provincia> getOne(@PathVariable("id") Long id){
		if(!provinciaServiceImpl.existsById(id))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		Provincia provincia = provinciaServiceImpl.getById(id).get();
		return new ResponseEntity(provincia, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {

		return null;
	}



	@Override
	@PostMapping("/create")
	public ResponseEntity<?> save(Provincia entity) {
		if(StringUtils.isBlank(entity.getDenominacion()))
			return new ResponseEntity(new Mensaje("La denominacion es obligatoria"), HttpStatus.BAD_REQUEST);
		if(entity.getCodigo().length() < 0)
			return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

		try {
			entity = provinciaServiceImpl.Save(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Provincia creada"), HttpStatus.OK);
	}

	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, Provincia entity) {
		try {
			if(provinciaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(StringUtils.isBlank(entity.getDenominacion()))
			return new ResponseEntity(new Mensaje("La denominacion es obligatoria"), HttpStatus.BAD_REQUEST);
		if(entity.getCodigo().length() < 0)
			return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

		try {
			entity = provinciaServiceImpl.Save(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Provincia actualizada"), HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
		try {
			if(provinciaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			provinciaServiceImpl.Delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Provincia eliminada"), HttpStatus.OK);
	}
}
