/*package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.presentation.dto.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.SIGER.SIGER.entities.Rol;
import com.SIGER.SIGER.services.RolServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController extends BaseControllerImpl<Rol, RolServiceImpl>{
	
	@Autowired
	RolServiceImpl rolServiceImpl;

	@GetMapping("/list")
	public ResponseEntity<List<Rol>> getAll(){
		List<Rol> list= rolServiceImpl.list();
		return new ResponseEntity<List<Rol>>(list, HttpStatus.OK);
	}

	@GetMapping("/detail-name/{nombre}")
	public ResponseEntity<Rol> getByNombre(@PathVariable("nombre") String nombreRol){
		if(!rolServiceImpl.existByNombreRol(nombreRol))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		Rol rol = rolServiceImpl.getByNombreRol(nombreRol).get();
		return new ResponseEntity(rol, HttpStatus.OK);
	}
	@GetMapping("/detail/{id}")
	public ResponseEntity<Rol> getOne(@PathVariable("id") Long id){
		if(!rolServiceImpl.existsById(id))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		Rol rol = rolServiceImpl.getById(id).get();
		return new ResponseEntity(rol, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping("/create")
	public ResponseEntity<?> save(Rol entity) {
		if(StringUtils.isBlank(entity.getNombreRol()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(entity.getCodigoRol().length()<0)
			return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

		try {
			entity = rolServiceImpl.Save(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Rol creado"), HttpStatus.OK);
	}

	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, Rol entity) {
		try {
			if(rolServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(StringUtils.isBlank(entity.getNombreRol()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(entity.getCodigoRol().length()<0)
			return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

		try {
			rolServiceImpl.Save(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Rol actualizado"), HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
		try {
			if(rolServiceImpl.getById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rolServiceImpl.Delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Rol eliminado"), HttpStatus.OK);
	}

}*/
