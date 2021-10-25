package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.entities.EstadoLicencia;
import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.entities.TipoLicencia;

import java.util.Optional;

@Repository
public interface TipoLicenciaRepository extends BaseRepository<TipoLicencia, Long>{
    Optional<TipoLicencia> findByNombreTipoLicencia(String nombreTipoLicencia);
    boolean existsByNombreTipoLicencia(String nombreTipoLicencia);
}
