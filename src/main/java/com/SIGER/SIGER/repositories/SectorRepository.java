package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.model.entities.Sector;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends BaseRepository<Sector, Long>{

  Optional<Sector> findByDenominacion(String denominacion);
  boolean existsByDenominacion(String denominacion);

}
