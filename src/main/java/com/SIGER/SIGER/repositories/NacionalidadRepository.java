package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.model.entities.Nacionalidad;
import com.SIGER.SIGER.servicesInterfaces.BaseService;
import org.springframework.stereotype.Repository;

@Repository
public interface NacionalidadRepository extends BaseRepository<Nacionalidad, Long> {
}
