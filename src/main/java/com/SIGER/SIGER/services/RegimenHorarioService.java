package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.RegimenHorario;
import com.SIGER.SIGER.repositories.RegimenHorarioRepository;
import com.SIGER.SIGER.servicesInterfaces.IRegimenHorarioService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class RegimenHorarioService extends AbsBaseService<RegimenHorario, Long> implements
    IRegimenHorarioService {

  @Autowired
  RegimenHorarioRepository regimenHorarioRepository;

}
