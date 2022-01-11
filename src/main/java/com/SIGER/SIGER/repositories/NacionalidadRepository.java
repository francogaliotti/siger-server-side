package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.model.entities.Nacionalidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface NacionalidadRepository extends BaseRepository<Nacionalidad, Long> {

  Page<Nacionalidad> findAll(Pageable pageable);
}
