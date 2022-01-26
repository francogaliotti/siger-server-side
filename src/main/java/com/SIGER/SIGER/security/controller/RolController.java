package com.SIGER.SIGER.security.controller;

import com.SIGER.SIGER.common.Message;

import com.SIGER.SIGER.security.entity.Rol;
import com.SIGER.SIGER.security.service.RolService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController{
	
	@Autowired
	RolService rolServiceImpl;

	@GetMapping("/list")
	public ResponseEntity<List<Rol>> getAll(){
		List<Rol> list= rolServiceImpl.list();
		return new ResponseEntity<List<Rol>>(list, HttpStatus.OK);
	}

	/*@GetMapping("/detail-name/{nombre}")
	public ResponseEntity<Rol> getByNombre(@PathVariable("nombre") String nombreRol){
		if(!rolServiceImpl.existByNombreRol(nombreRol))
			return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
		Rol rol = rolServiceImpl.getByNombreRol(nombreRol).get();
		return new ResponseEntity(rol, HttpStatus.OK);
	}*/
	@GetMapping("/detail/{id}")
	public ResponseEntity<Rol> getOne(@PathVariable("id") Long id){
		if(!rolServiceImpl.existsById(id))
			return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
		Rol rol = rolServiceImpl.getById(id).get();
		return new ResponseEntity(rol, HttpStatus.OK);
	}


	public ResponseEntity<?> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@PostMapping("/create")
	public ResponseEntity<?> save(Rol entity) {
		if(StringUtils.isBlank(entity.getRolNombre()))
			return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

		try {
			rolServiceImpl.save(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Message("Rol creado"), HttpStatus.OK);
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, Rol entity) {
		try {
			if(rolServiceImpl.getById(id).equals(false))
				return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(StringUtils.isBlank(entity.getRolNombre()))
			return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

		try {
			rolServiceImpl.save(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Message("Rol actualizado"), HttpStatus.OK);
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
		try {
			if(rolServiceImpl.getById(id).equals(false))
				return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rolServiceImpl.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Message("Rol eliminado"), HttpStatus.OK);
	}

}
