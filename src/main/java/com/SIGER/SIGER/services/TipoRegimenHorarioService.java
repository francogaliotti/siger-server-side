package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.TipoRegimenHorario;
import com.SIGER.SIGER.repositories.TipoRegimenHorarioRepository;
import com.SIGER.SIGER.servicesInterfaces.ITipoRegimenHorarioService;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional
@NoArgsConstructor
public class TipoRegimenHorarioService extends
    AbsBaseService<TipoRegimenHorario, Long> implements
    ITipoRegimenHorarioService {

  @Autowired
  TipoRegimenHorarioRepository tipoRegimenHorarioRepository;
	
	
	/*public TipoRegimenHorarioService(BaseRepository<TipoRegimenHorario, Long> baseRepository) {
      super(baseRepository);
  }*/

  @Transactional
  public boolean existsByDenominacionTipoRegimenHorario(String denominacionTipoRegimenHorario) {
    return tipoRegimenHorarioRepository.existsByDenominacionTipoRegimenHorario(
        denominacionTipoRegimenHorario);
  }

}
