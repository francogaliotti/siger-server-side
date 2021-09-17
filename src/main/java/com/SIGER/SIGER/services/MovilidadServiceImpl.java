package com.SIGER.SIGER.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Movilidad;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.MovilidadRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class MovilidadServiceImpl extends BaseServiceImpl<Movilidad, Long> implements MovilidadService{
	
	@Autowired
	private MovilidadRepository movilidadRepository;
	
	
	public MovilidadServiceImpl(BaseRepository<Movilidad, Long> baseRepository) {
      super(baseRepository);
  }

}
