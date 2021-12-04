package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.IJornadaLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.RegimenHorario;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.JornadaLaboralRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class JornadaLaboralService extends
    AbsBaseService<RegimenHorario, Long> implements IJornadaLaboralService {
	
	@Autowired
	private JornadaLaboralRepository jornadaLaboralRepository;
	
	
	public JornadaLaboralService(BaseRepository<RegimenHorario, Long> baseRepository) {
      super(baseRepository);
  }

}
