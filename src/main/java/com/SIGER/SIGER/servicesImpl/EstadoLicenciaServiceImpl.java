package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.entities.EstadoBoleta;
import com.SIGER.SIGER.services.EstadoLicenciaService;
import com.SIGER.SIGER.servicesImpl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.EstadoLicencia;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.EstadoLicenciaRepository;

import lombok.NoArgsConstructor;

import java.util.Optional;

@Service
//@Transactional
@NoArgsConstructor
public class EstadoLicenciaServiceImpl extends BaseServiceImpl<EstadoLicencia, Long> implements EstadoLicenciaService {
	
	@Autowired
	private EstadoLicenciaRepository estadoLicenciaRepository;
	
	
	public EstadoLicenciaServiceImpl(BaseRepository<EstadoLicencia, Long> baseRepository) { super(baseRepository); }

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
