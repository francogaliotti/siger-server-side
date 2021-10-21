package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Domicilio;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.DomicilioRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {
	
	@Autowired
	private DomicilioRepository domicilioRepository ;
	
	
	public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository) {
      super(baseRepository);
  }

}
