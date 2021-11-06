package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.entities.TipoBoleta;
import com.SIGER.SIGER.repositories.TipoBoletaRepository;
import com.SIGER.SIGER.services.TipoBoletaService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoBoletaServiceImpl extends BaseServiceImpl<TipoBoleta, Long> implements TipoBoletaService {
	
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
