package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.TipoBoleta;
import com.SIGER.SIGER.repositories.TipoBoletaRepository;
import com.SIGER.SIGER.servicesInterfaces.ITipoBoletaService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoBoletaService extends AbsBaseService<TipoBoleta, Long> implements
    ITipoBoletaService {
	
	@Autowired
  TipoBoletaRepository tipoBoletaRepository;

  @Transactional
  public Optional<TipoBoleta> getByCodigo(String codigo) {
    return tipoBoletaRepository.findByCodigo(codigo);
  }

  @Transactional
  public boolean existsByCodigo(String codigo) {
    return tipoBoletaRepository.existsByCodigo(codigo);
  }

  @Transactional
  public Optional<TipoBoleta> getByTipoBoletaDenominacion(String tipoBoletaDenominacion) {
    return tipoBoletaRepository.findByTipoBoletaDenominacion(tipoBoletaDenominacion);
  }

  @Transactional
  public boolean existsByTipoBoletaDenominacion(String tipoBoletaDenominacion) {
    return tipoBoletaRepository.existsByTipoBoletaDenominacion(tipoBoletaDenominacion);
  }
	


}
