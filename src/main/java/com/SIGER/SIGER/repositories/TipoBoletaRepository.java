package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.entities.TipoBoleta;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoBoletaRepository extends BaseRepository<TipoBoleta, Long>{

  Optional<TipoBoleta> findByTipoBoletaDenominacion(String tipoBoletaDenominacion);
  boolean existsByTipoBoletaDenominacion(String tipoBoletaDenominacion);

}
