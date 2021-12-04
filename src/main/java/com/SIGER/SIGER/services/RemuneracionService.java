package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.IRemuneracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.Remuneracion;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.RemuneracionRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class RemuneracionService extends AbsBaseService<Remuneracion, Long> implements
		IRemuneracionService {
	
	@Autowired
	private RemuneracionRepository remuneracionRepository;
	
	
	public RemuneracionService(BaseRepository<Remuneracion, Long> baseRepository) {
      super(baseRepository);
  }

}
