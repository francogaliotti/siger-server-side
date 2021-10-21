package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.ZonaInhospitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.ZonaInhospita;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.ZonaInhospitaRepository;

import lombok.NoArgsConstructor;

import java.util.Optional;

@Service
//@Transactional
@NoArgsConstructor
public class ZonaInhospitaServiceImpl extends BaseServiceImpl<ZonaInhospita, Long> implements ZonaInhospitaService {
	
	@Autowired
	private ZonaInhospitaRepository zonaInhospitaRepository;
	
	
	public ZonaInhospitaServiceImpl(BaseRepository<ZonaInhospita, Long> baseRepository) {
      super(baseRepository);
  }

	public Optional<ZonaInhospita> getByDenominacionZona(String nombre){
		return zonaInhospitaRepository.findByDenominacionZona(nombre);
	}

	public boolean existsById (Long id) {
		return zonaInhospitaRepository.existsById(id);
	}

	public boolean existsByDenominacionZona (String denominacion) {
		return zonaInhospitaRepository.existsByDenominacionZona(denominacion);
	}

}
