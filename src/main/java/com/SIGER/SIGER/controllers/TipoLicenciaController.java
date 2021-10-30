package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.entities.Empleado;
import com.SIGER.SIGER.entities.TipoRequerimiento;
import com.SIGER.SIGER.presentation.dto.LicenciaDTO;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.dto.TipoLicenciaDTO;
import com.SIGER.SIGER.servicesImpl.*;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
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


	public ResponseEntity<?> getAll(Pageable pageable) {
		List<TipoLicencia> tiposLicencia = null;
		try {
			tiposLicencia = tipoLicenciaServiceImpl.FindAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(tiposLicencia, HttpStatus.OK);
	}

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

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> save(TipoLicenciaDTO tipoLicenciaDTO) throws Exception {
		if(StringUtils.isBlank(tipoLicenciaDTO.getDenominacion()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(tipoLicenciaDTO.getCodigo().length()<0)
			return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
		if(tipoLicenciaServiceImpl.existsByNombreTipoLicencia(tipoLicenciaDTO.getDenominacion()))
			return new ResponseEntity(new Mensaje("El nombre del tipo ya existe"), HttpStatus.BAD_REQUEST);
		ModelMapper modelMapper = new ModelMapper();
		TipoLicencia tipoLicencia = modelMapper.map(tipoLicenciaDTO,TipoLicencia.class);
		try{
			tipoLicenciaServiceImpl.Save(tipoLicencia);
		} catch (Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Tipo de licencia creado"),HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, TipoLicenciaDTO tipoLicenciaDTO) {
		try {
			if(tipoLicenciaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(StringUtils.isBlank(tipoLicenciaDTO.getDenominacion()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(tipoLicenciaDTO.getCodigo().length()<0)
			return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
		if(tipoLicenciaServiceImpl.existsByNombreTipoLicencia(tipoLicenciaDTO.getDenominacion()))
			return new ResponseEntity(new Mensaje("El nombre del tipo ya existe"), HttpStatus.BAD_REQUEST);
		ModelMapper modelMapper = new ModelMapper();
		TipoLicencia tipoLicencia = modelMapper.map(tipoLicenciaDTO,TipoLicencia.class);
		try {
			tipoLicenciaServiceImpl.Update(id, tipoLicencia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Tipo de Licencia actualizado"), HttpStatus.OK);
	}

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
