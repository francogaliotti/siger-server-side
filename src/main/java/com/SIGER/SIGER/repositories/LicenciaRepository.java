package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.datos_gob_ar.entities.Localidad;
import com.SIGER.SIGER.model.entities.TipoLicencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.model.entities.Licencia;

import java.util.Optional;

@Repository
public interface LicenciaRepository extends BaseRepository<Licencia, Long>{
    /*@Query(value = "SELECT * FROM licencia l WHERE l.fk_empleado = :empleado_id",
            nativeQuery = true)
    Page<Licencia> findByEmpleado(Pageable pageable, @Param("fk_empleado") Long id);*/
}
