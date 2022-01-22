package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.Asistencia;
import com.SIGER.SIGER.repositories.AsistenciaRepository;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.servicesInterfaces.IAsistenciaService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaService extends AbsBaseService<Asistencia, Long> implements
    IAsistenciaService {

  @Autowired
  AsistenciaRepository asistenciaRepository;

  public AsistenciaService(BaseRepository<Asistencia, Long> baseRepository) {
    super(baseRepository);
  }

  @Transactional
  public Page<Asistencia> findByEmpleado(Long id, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return asistenciaRepository.findByEmpleado(id, pageable);
  }


}
