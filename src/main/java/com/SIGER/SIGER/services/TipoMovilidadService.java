package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.ITipoMovilidadService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.TipoMovilidad;
import com.SIGER.SIGER.repositories.TipoMovilidadRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class TipoMovilidadService extends AbsBaseService<TipoMovilidad, Long> implements
		ITipoMovilidadService {
	
	@Autowired
	TipoMovilidadRepository tipoMovilidadRepository;
	
	
	/*public TipoMovilidadService(BaseRepository<TipoMovilidad, Long> baseRepository) {
      super(baseRepository);
  }*/

	@Transactional
	public boolean existsByDenominacion(String denominacion) {
		return tipoMovilidadRepository.existsByDenominacion(denominacion);
	}

}
