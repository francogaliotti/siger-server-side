package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.RemuneracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Remuneracion;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.RemuneracionRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class RemuneracionServiceImpl extends BaseServiceImpl<Remuneracion, Long> implements RemuneracionService {
	
	@Autowired
	private RemuneracionRepository remuneracionRepository;
	
	
	public RemuneracionServiceImpl(BaseRepository<Remuneracion, Long> baseRepository) {
      super(baseRepository);
  }

}
