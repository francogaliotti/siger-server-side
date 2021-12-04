package com.SIGER.SIGER.repositories;

import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.model.entities.Provincia;

import java.util.Optional;

@Repository
public interface ProvinciaRepository extends BaseRepository<Provincia, Long>{
    Optional<Provincia> findByDenominacion(String denominacion);
    boolean existsByDenominacion(String denominacion);
}
