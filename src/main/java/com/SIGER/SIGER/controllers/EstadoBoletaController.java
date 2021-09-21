package com.SIGER.SIGER.controllers;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.entities.EstadoBoleta;
import com.SIGER.SIGER.services.EstadoBoletaServiceImpl;

@RestController
@RequestMapping("/estadoBoleta")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoBoletaController extends BaseControllerImpl<EstadoBoleta, EstadoBoletaServiceImpl>{
	
	@Autowired
	EstadoBoletaServiceImpl estadoboletaServiceImpl;

	// Override methods
	
	@Override
	@GetMapping("/list")
	public ResponseEntity<List<EstadoBoleta>> getAll() {
		List<EstadoBoleta> list = null;
		try {
			list = estadoboletaServiceImpl.FindAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}
		
	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getOne(Long id) {
		try {
			if(estadoboletaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EstadoBoleta estadoBoleta = null;
		try {
			estadoBoleta = estadoboletaServiceImpl.FindById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(estadoBoleta, HttpStatus.OK);
	}

	@GetMapping("/detailname/{nombre}")
	public ResponseEntity<EstadoBoleta> getByNombre(@PathVariable("nombre") String nombreEstadoBoleta){
		if(!estadoboletaServiceImpl.existsByNombreEstadoBoleta(nombreEstadoBoleta))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		EstadoBoleta estadoBoleta = estadoboletaServiceImpl.getByNombreEstadoBoleta(nombreEstadoBoleta).get();
		return new ResponseEntity(estadoBoleta, HttpStatus.OK);
	}

	@Override
	@PostMapping("/create")
	public ResponseEntity<?> save(EstadoBoleta estadoBoleta) {
		try {
			estadoBoleta = estadoboletaServiceImpl.Save(estadoBoleta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Estado de Boleta creado"), HttpStatus.OK);
	}


	/*@PostMapping("/createDTO")
	public ResponseEntity<?> createDTO(@RequestBody EstadoBoletaDTO estadoBoletaDTO){
		if(StringUtils.isBlank(estadoBoletaDTO.getNombreEstadoBoleta()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(estadoBoletaDTO.getCodEstadoBoleta()<0)
			return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
		if(estadoboletaServiceImpl.existsByNombreEstadoBoleta(estadoBoletaDTO.getNombreEstadoBoleta()))
			return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
		EstadoBoleta estadoBoleta = EstadoBoleta.builder().codEstadoBoleta(estadoBoletaDTO.getCodEstadoBoleta()).
				nombreEstadoBoleta(estadoBoletaDTO.getNombreEstadoBoleta()).build();
		try {
			estadoboletaServiceImpl.Save(estadoBoleta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Estado de Boleta creado"), HttpStatus.OK);
	}*/


	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(Long id, EstadoBoleta estadoBoleta) {
		try {
			if(estadoboletaServiceImpl.FindById(id).equals(false))
				return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(StringUtils.isBlank(estadoBoleta.getNombreEstadoBoleta()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(estadoBoleta.getCodEstadoBoleta().length()<0)
			return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
		
		try {
			estadoboletaServiceImpl.Update(id, estadoBoleta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Estado de Boleta actualizado"), HttpStatus.OK);
	}

		/*

	@PutMapping("/updateDTO/{id}")
	public ResponseEntity<?> updateDTO(@PathVariable("id") Long id, @RequestBody EstadoBoletaDTO estadoBoletaDTO){
		if(!estadoboletaServiceImpl.existsById(id))
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		if(estadoboletaServiceImpl.existsByNombreEstadoBoleta(estadoBoletaDTO.getNombreEstadoBoleta()) && estadoboletaServiceImpl.getByNombreEstadoBoleta(estadoBoletaDTO.getNombreEstadoBoleta()).get().getId() != id)
			return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(estadoBoletaDTO.getNombreEstadoBoleta()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(estadoBoletaDTO.getCodEstadoBoleta()<0)
			return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

		EstadoBoleta estadoBoleta = null;
		try {
			estadoBoleta = estadoboletaServiceImpl.FindById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		estadoBoleta.setNombreEstadoBoleta(estadoBoletaDTO.getNombreEstadoBoleta());
		estadoBoleta.setCodEstadoBoleta(estadoBoletaDTO.getCodEstadoBoleta());
		try {
			estadoboletaServiceImpl.Save(estadoBoleta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Estado de Boleta actualizado"), HttpStatus.OK);
	}*/

	@Override
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(Long id) {
			try {
				if(estadoboletaServiceImpl.FindById(id).equals(false))
					return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				estadoboletaServiceImpl.Delete(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity(new Mensaje("Estado de Boleta eliminado"), HttpStatus.OK);
	}

}
