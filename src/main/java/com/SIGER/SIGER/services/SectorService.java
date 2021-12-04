package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.Sector;
import com.SIGER.SIGER.repositories.SectorRepository;
import com.SIGER.SIGER.servicesInterfaces.ISectorService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SectorService extends AbsBaseService<Sector, Long> implements
    ISectorService {
	
	@Autowired
  SectorRepository sectorRepository;

  @Transactional
  public Optional<Sector> getByDenominacion(String denominacion) {
    return sectorRepository.findByDenominacion(denominacion);
  }

  @Transactional
  public boolean existsByDenominacion(String denominacion) {
    return sectorRepository.existsByDenominacion(denominacion);
  }

}
