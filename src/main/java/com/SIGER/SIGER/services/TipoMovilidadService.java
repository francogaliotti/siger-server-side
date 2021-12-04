package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.ITipoMovilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.TipoMovilidad;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.TipoMovilidadRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class TipoMovilidadService extends AbsBaseService<TipoMovilidad, Long> implements
		ITipoMovilidadService {
	
	@Autowired
	private TipoMovilidadRepository tipoMovilidadRepository;
	
	
	public TipoMovilidadService(BaseRepository<TipoMovilidad, Long> baseRepository) {
      super(baseRepository);
  }

}
