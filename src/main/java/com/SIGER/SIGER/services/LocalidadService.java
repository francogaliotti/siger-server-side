package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.ILocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.Localidad;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.LocalidadRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class LocalidadService extends AbsBaseService<Localidad, Long> implements
		ILocalidadService {
	
	@Autowired
	private LocalidadRepository localidadRepository;
	
	
	public LocalidadService(BaseRepository<Localidad, Long> baseRepository) {
      super(baseRepository);
  }

}
