package com.SIGER.SIGER.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Provincia;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.ProvinciaRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class ProvinciaServiceImpl extends BaseServiceImpl<Provincia, Long> implements ProvinciaService{
	
	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	
	public ProvinciaServiceImpl(BaseRepository<Provincia, Long> baseRepository) {
      super(baseRepository);
  }

}
