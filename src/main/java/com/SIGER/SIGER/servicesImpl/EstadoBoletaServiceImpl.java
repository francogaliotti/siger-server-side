package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.entities.EstadoBoleta;
import com.SIGER.SIGER.repositories.EstadoBoletaRepository;
import com.SIGER.SIGER.services.EstadoBoletaService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoBoletaServiceImpl extends BaseServiceImpl<EstadoBoleta, Long> implements
    EstadoBoletaService {

  @Autowired
  EstadoBoletaRepository estadoBoletaRepository;

	@Transactional
  public Optional<EstadoBoleta> getByNombreEstadoBoleta(String nombre) {
    return estadoBoletaRepository.findByNombreEstadoBoleta(nombre);
  }

	@Transactional
  public boolean existsById(Long id) {
    return estadoBoletaRepository.existsById(id);
  }

	@Transactional
  public boolean existsByNombreEstadoBoleta(String nombre) {
    return estadoBoletaRepository.existsByNombreEstadoBoleta(nombre);
  }

}