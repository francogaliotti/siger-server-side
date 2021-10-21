package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.EstadoLicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.EstadoLicencia;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.EstadoLicenciaRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class EstadoLicenciaServiceImpl extends BaseServiceImpl<EstadoLicencia, Long> implements EstadoLicenciaService {
	
	@Autowired
	private EstadoLicenciaRepository estadoLicenciaRepository;
	
	
	public EstadoLicenciaServiceImpl(BaseRepository<EstadoLicencia, Long> baseRepository) { super(baseRepository); }

}
