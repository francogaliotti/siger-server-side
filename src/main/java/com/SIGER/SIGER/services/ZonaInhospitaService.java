package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.IZonaInhospitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.ZonaInhospita;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.ZonaInhospitaRepository;

import lombok.NoArgsConstructor;

import java.util.Optional;

@Service
//@Transactional
@NoArgsConstructor
public class ZonaInhospitaService extends AbsBaseService<ZonaInhospita, Long> implements
		IZonaInhospitaService {
	
	@Autowired
	private ZonaInhospitaRepository zonaInhospitaRepository;
	
	
	public ZonaInhospitaService(BaseRepository<ZonaInhospita, Long> baseRepository) {
      super(baseRepository);
  }

	public Optional<ZonaInhospita> getByDenominacionZona(String nombre){
		return zonaInhospitaRepository.findByDenominacionZona(nombre);
	}

	public boolean existsById (Long id) {
		return zonaInhospitaRepository.existsById(id);
	}

	public boolean existsByDenominacionZona (String den) {
		return zonaInhospitaRepository.existsByDenominacionZona(den);
	}

}
