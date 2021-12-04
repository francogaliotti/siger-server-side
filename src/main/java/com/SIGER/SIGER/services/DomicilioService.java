package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.Domicilio;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.DomicilioRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class DomicilioService extends AbsBaseService<Domicilio, Long> implements
		IDomicilioService {
	
	@Autowired
	private DomicilioRepository domicilioRepository ;
	
	
	public DomicilioService(BaseRepository<Domicilio, Long> baseRepository) {
      super(baseRepository);
  }

}
