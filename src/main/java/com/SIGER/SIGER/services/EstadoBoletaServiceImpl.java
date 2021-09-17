package com.SIGER.SIGER.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.EstadoBoleta;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.EstadoBoletaRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class EstadoBoletaServiceImpl extends BaseServiceImpl<EstadoBoleta, Long> implements EstadoBoletaService{
	
	@Autowired
	private EstadoBoletaRepository estadoBoletaRepository;
	
	
	public EstadoBoletaServiceImpl(BaseRepository<EstadoBoleta, Long> baseRepository) { super(baseRepository); }
	
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