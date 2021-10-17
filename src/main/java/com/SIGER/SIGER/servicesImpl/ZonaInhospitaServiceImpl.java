package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.ZonaInhospitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.ZonaInhospita;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.ZonaInhospitaRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class ZonaInhospitaServiceImpl extends BaseServiceImpl<ZonaInhospita, Long> implements ZonaInhospitaService {
	
	@Autowired
	private ZonaInhospitaRepository zonaInhospitaRepository;
	
	
	public ZonaInhospitaServiceImpl(BaseRepository<ZonaInhospita, Long> baseRepository) {
      super(baseRepository);
  }

}
