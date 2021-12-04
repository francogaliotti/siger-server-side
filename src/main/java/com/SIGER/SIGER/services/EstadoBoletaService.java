package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.EstadoBoleta;
import com.SIGER.SIGER.repositories.EstadoBoletaRepository;
import com.SIGER.SIGER.servicesInterfaces.IEstadoBoletaService;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class EstadoBoletaService extends AbsBaseService<EstadoBoleta, Long> implements
    IEstadoBoletaService {

  @Autowired
  EstadoBoletaRepository estadoBoletaRepository;

  /*public EstadoBoletaService(BaseRepository<EstadoBoleta, Long> baseRepository) {
    super(baseRepository);
  }*/

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