package com.SIGER.SIGER.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.TipoSector;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.TipoSectorRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class TipoSectorServiceImpl extends BaseServiceImpl<TipoSector, Long> implements TipoSectorService{
	
	@Autowired
	private TipoSectorRepository tipoSectorRepository;
	
	
	public TipoSectorServiceImpl(BaseRepository<TipoSector, Long> baseRepository) {
      super(baseRepository);
  }

}
