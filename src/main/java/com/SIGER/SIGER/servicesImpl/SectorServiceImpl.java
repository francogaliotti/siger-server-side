package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.entities.Sector;
import com.SIGER.SIGER.repositories.SectorRepository;
import com.SIGER.SIGER.services.SectorService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SectorServiceImpl extends BaseServiceImpl<Sector, Long> implements SectorService {
	
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
