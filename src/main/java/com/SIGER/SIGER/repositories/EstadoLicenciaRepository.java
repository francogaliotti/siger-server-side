package com.SIGER.SIGER.repositories;

import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.model.entities.EstadoLicencia;

import java.util.Optional;

@Repository
public interface EstadoLicenciaRepository extends BaseRepository<EstadoLicencia, Long>{
    Optional<EstadoLicencia> findByNombreEstadoLicencia(String nombreEstadoLicencia);
    boolean existsByNombreEstadoLicencia(String nombreEstadoLicencia);
}
