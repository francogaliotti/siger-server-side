package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.dto.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SIGER.SIGER.entities.EstadoLicencia;
import com.SIGER.SIGER.services.EstadoLicenciaServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/estadoLicencia")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoLicenciaController extends BaseControllerImpl<EstadoLicencia, EstadoLicenciaServiceImpl>{
	
	@Autowired
	EstadoLicenciaServiceImpl estadoLicenciaServiceImpl;

	@Override
	public ResponseEntity<?> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		List<EstadoLicencia> estadosLicencia = null;
		try {
			estadosLicencia = estadoLicenciaServiceImpl.FindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(estadosLicencia, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getOne(Long id) {
		try {
			if(estadoLicenciaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		EstadoLicencia estadoLicencia = null;

		try{
			estadoLicencia = estadoLicenciaServiceImpl.FindById(id);
		} catch (Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity(estadoLicencia, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> save(EstadoLicencia estadoLicencia) {
		try{
			estadoLicencia = estadoLicenciaServiceImpl.Save(estadoLicencia);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Estado de Licencia creado"), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> update(Long id, EstadoLicencia estadoLicencia) {
		try {
			if(estadoLicenciaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(StringUtils.isBlank(estadoLicencia.getNombreEstadoLicencia()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(estadoLicencia.getCodEstadoLicencia().length()<0)
			return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

		try {
			estadoLicenciaServiceImpl.Update(id, estadoLicencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Estado de Licencia actualizado"), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		try {
			if(estadoLicenciaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			estadoLicenciaServiceImpl.Delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Estado de Licencia eliminado"), HttpStatus.OK);
	}

}
