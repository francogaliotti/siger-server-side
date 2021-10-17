package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.TipoMovilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.TipoMovilidad;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.TipoMovilidadRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class TipoMovilidadServiceImpl extends BaseServiceImpl<TipoMovilidad, Long> implements TipoMovilidadService {
	
	@Autowired
	private TipoMovilidadRepository tipoMovilidadRepository;
	
	
	public TipoMovilidadServiceImpl(BaseRepository<TipoMovilidad, Long> baseRepository) {
      super(baseRepository);
  }

}
