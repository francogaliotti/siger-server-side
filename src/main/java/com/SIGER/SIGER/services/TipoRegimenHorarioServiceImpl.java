package com.SIGER.SIGER.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.TipoRegimenHorario;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.TipoRegimenHorarioRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class TipoRegimenHorarioServiceImpl extends BaseServiceImpl<TipoRegimenHorario, Long> implements TipoRegimenHorarioService {
	
	@Autowired
	private TipoRegimenHorarioRepository tipoRegimenHorarioRepository;
	
	
	public TipoRegimenHorarioServiceImpl(BaseRepository<TipoRegimenHorario, Long> baseRepository) {
      super(baseRepository);
  }

}
