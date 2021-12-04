package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.model.entities.Permiso;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface PermisoRepository  extends BaseRepository<Permiso, Long>{
    Optional<Permiso> findByNombrePermiso(String nombrePermiso);
    boolean existsByNombrePermiso(String nombrePermiso);

}
