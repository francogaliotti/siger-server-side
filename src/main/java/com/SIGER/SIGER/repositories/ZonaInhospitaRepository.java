package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.entities.EstadoLicencia;
import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.entities.ZonaInhospita;

import java.util.Optional;

@Repository
public interface ZonaInhospitaRepository extends BaseRepository<ZonaInhospita, Long>{
    Optional<ZonaInhospita> findByDenominacionZona(String denominacionZona);
    boolean existsByDenominacionZona(String denominacionZona);
}
