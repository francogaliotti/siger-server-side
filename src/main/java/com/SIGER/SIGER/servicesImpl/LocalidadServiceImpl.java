package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Localidad;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.LocalidadRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {
	
	@Autowired
	private LocalidadRepository localidadRepository;
	
	
	public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
      super(baseRepository);
  }

}
