package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.IMovilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.Movilidad;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.MovilidadRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class MovilidadService extends AbsBaseService<Movilidad, Long> implements
		IMovilidadService {
	
	@Autowired
	private MovilidadRepository movilidadRepository;
	
	
	public MovilidadService(BaseRepository<Movilidad, Long> baseRepository) {
      super(baseRepository);
  }

}
