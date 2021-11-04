package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.entities.TipoSector;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSectorRepository extends BaseRepository<TipoSector, Long>{

  Optional<TipoSector> findByCodTipoSector(String codTipoSector);
  boolean existsByCodTipoSector(String codTipoSector);

  Optional<TipoSector> findByNombreTipoSector(String nombreTipoSector);
  boolean existsByNombreTipoSector(String nombreTipoSector);

}
