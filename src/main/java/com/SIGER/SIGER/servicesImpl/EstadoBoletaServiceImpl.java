package com.SIGER.SIGER.servicesImpl;

import java.util.Optional;

import com.SIGER.SIGER.services.EstadoBoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.EstadoBoleta;
import com.SIGER.SIGER.repositories.EstadoBoletaRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class EstadoBoletaServiceImpl extends BaseServiceImpl<EstadoBoleta, Long> implements EstadoBoletaService {
	
	@Autowired
	EstadoBoletaRepository estadoBoletaRepository;
	
	public Optional<EstadoBoleta> getByNombreEstadoBoleta(String nombre){
		return estadoBoletaRepository.findByNombreEstadoBoleta(nombre);
	}
	
	public boolean existsById (Long id) {
		return estadoBoletaRepository.existsById(id);
	}
	
	public boolean existsByNombreEstadoBoleta (String nombre) {
		return estadoBoletaRepository.existsByNombreEstadoBoleta(nombre);
	}
	
}