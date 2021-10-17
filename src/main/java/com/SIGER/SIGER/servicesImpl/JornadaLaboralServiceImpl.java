package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.JornadaLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.RegimenHorario;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.JornadaLaboralRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class JornadaLaboralServiceImpl extends BaseServiceImpl<RegimenHorario, Long> implements JornadaLaboralService {
	
	@Autowired
	private JornadaLaboralRepository jornadaLaboralRepository;
	
	
	public JornadaLaboralServiceImpl(BaseRepository<RegimenHorario, Long> baseRepository) {
      super(baseRepository);
  }

}
