package com.SIGER.SIGER.repositories;

import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.entities.Viatico;

import java.util.Optional;

@Repository
public interface ViaticoRepository extends BaseRepository<Viatico, Long>{

    Optional<Viatico> findByCodViatico(String codViatico);
    boolean existsByCodViatico(String codViatico);
}
