package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.TipoLicencia;
import com.SIGER.SIGER.repositories.TipoLicenciaRepository;
import com.SIGER.SIGER.servicesInterfaces.ITipoLicenciaService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TipoLicenciaService extends AbsBaseService<TipoLicencia, Long> implements
    ITipoLicenciaService {

  @Autowired
  private TipoLicenciaRepository tipoLicenciaRepository;


  public Optional<TipoLicencia> getByNombreTipoLicencia(String nombre) {
    return tipoLicenciaRepository.findByDenominacion(nombre);
  }

  public boolean existsById(Long id) {
    return tipoLicenciaRepository.existsById(id);
  }

  public boolean existsByNombreTipoLicencia(String nombre) {
    return tipoLicenciaRepository.existsByDenominacion(nombre);
  }

}
