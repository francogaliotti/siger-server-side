package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.dto.Cualquiera;
import com.SIGER.SIGER.entities.Empleado;
import com.SIGER.SIGER.entities.EstadoLicencia;
import com.SIGER.SIGER.entities.TipoRequerimiento;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.servicesImpl.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.SIGER.SIGER.entities.TipoLicencia;

import java.util.List;

@RestController
@RequestMapping("/tipoLicencia")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoLicenciaController /*extends BaseControllerImpl<TipoLicencia, TipoLicenciaServiceImpl>*/{

	@Autowired
	TipoLicenciaServiceImpl tipoLicenciaServiceImpl;
	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;
	@Autowired
	SectorServiceImpl sectorServiceImpl;

	@Override
	@GetMapping("/list")
	public ResponseEntity<?> getAll() {
		List<TipoLicencia> list = null;
		try{
			list = tipoLicenciaServiceImpl.FindAll();
		}catch (Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		List<TipoLicencia> tiposLicencia = null;
		try {
			tiposLicencia = tipoLicenciaServiceImpl.FindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(tiposLicencia, HttpStatus.OK);
	}

	@Override
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getOne(Long id) {
		try {
			if(tipoLicenciaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TipoLicencia tipoLicencia = null;

		try{
			tipoLicencia = tipoLicenciaServiceImpl.FindById(id);
		} catch (Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity(tipoLicencia, HttpStatus.OK);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> save(Cualquiera cualquiera) throws Exception {
		TipoLicencia tipoLicencia1 = new TipoLicencia();
		tipoLicencia1.setCodigo(cualquiera.getCodigo());
		tipoLicencia1.setDenominacion(cualquiera.getDenominacion());

		Empleado empleado = empleadoServiceImpl.FindById(cualquiera.getAutorizadores());
		TipoRequerimiento tipoRequerimiento = new TipoRequerimiento();
		tipoRequerimiento.setAprobadores(empleado);
		tipoLicencia1.setTipoRequerimiento(tipoRequerimiento);
		tipoRequerimiento.setAprueban();

		try{
			tipoLicencia = tipoLicenciaServiceImpl.Save(tipoLicencia);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Tipo de Licencia creado"), HttpStatus.OK);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, TipoLicencia tipoLicencia) {
		try {
			if(tipoLicenciaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(StringUtils.isBlank(tipoLicencia.getDenominacion()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(tipoLicencia.getCodigo().length()<0)
			return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

		try {
			tipoLicenciaServiceImpl.Update(id, tipoLicencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Tipo de Licencia actualizado"), HttpStatus.OK);
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
		try {
			if(tipoLicenciaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			tipoLicenciaServiceImpl.Delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Tipo de Licencia eliminado"), HttpStatus.OK);
	}

}
