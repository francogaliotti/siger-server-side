package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.IEstadoLicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.EstadoLicencia;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.EstadoLicenciaRepository;

import lombok.NoArgsConstructor;

import java.util.Optional;

@Service
@NoArgsConstructor
public class EstadoLicenciaService extends
    AbsBaseService<EstadoLicencia, Long> implements IEstadoLicenciaService {
	
	@Autowired
	private EstadoLicenciaRepository estadoLicenciaRepository;
	
	
	public EstadoLicenciaService(BaseRepository<EstadoLicencia, Long> baseRepository) { super(baseRepository); }

	public Optional<EstadoLicencia> getByNombreEstadoLicencia(String nombre){
		return estadoLicenciaRepository.findByNombreEstadoLicencia(nombre);
	}

	public boolean existsById (Long id) {
		return estadoLicenciaRepository.existsById(id);
	}

	public boolean existsByNombreEstadoLicencia (String nombre) {
		return estadoLicenciaRepository.existsByNombreEstadoLicencia(nombre);
	}
}
