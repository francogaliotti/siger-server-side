package com.SIGER.SIGER.repositories;

import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.model.entities.TipoLicencia;

import java.util.Optional;

@Repository
public interface TipoLicenciaRepository extends BaseRepository<TipoLicencia, Long>{
    Optional<TipoLicencia> findByDenominacion(String nombreTipoLicencia);
    boolean existsByDenominacion(String nombreTipoLicencia);
}
