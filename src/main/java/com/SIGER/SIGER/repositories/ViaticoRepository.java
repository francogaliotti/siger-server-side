package com.SIGER.SIGER.repositories;

import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.model.entities.Viatico;

import java.util.Optional;

@Repository
public interface ViaticoRepository extends BaseRepository<Viatico, Long>{

    Optional<Viatico> findByCodViatico(String codViatico);
    boolean existsByCodViatico(String codViatico);

    Optional<Viatico> findByDenominacionViatico(String denominacionViatico);
    boolean existsByDenominacionViatico(String denominacionViatico);
}
