package com.SIGER.SIGER.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.model.entities.Licencia;

import java.util.Date;
import java.util.List;

@Repository
public interface LicenciaRepository extends BaseRepository<Licencia, Long>{

    @Query(value = "SELECT * FROM licencia l WHERE l.fk_empleado = :empleado_id AND l.fechaAlta BETWEEN :dateFrom AND :dateTo",
            nativeQuery = true)
    List<Licencia> getByDateFrom_DateTo_Employee(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo, @Param("empleado_id") Long empleado_id);

}
