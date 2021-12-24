package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.ITipoRegimenHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.TipoRegimenHorario;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.TipoRegimenHorarioRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class TipoRegimenHorarioService extends
    AbsBaseService<TipoRegimenHorario, Long> implements
		ITipoRegimenHorarioService {
	
	@Autowired
	private TipoRegimenHorarioRepository tipoRegimenHorarioRepository;
	
	
	public TipoRegimenHorarioService(BaseRepository<TipoRegimenHorario, Long> baseRepository) {
      super(baseRepository);
  }

}
