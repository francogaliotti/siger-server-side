package com.SIGER.SIGER.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.model.entities.Asistencia;

import java.util.Date;
import java.util.List;

@Repository
public interface AsistenciaRepository extends BaseRepository<Asistencia, Long> {

    @Query(value = "SELECT * FROM Asistencia a WHERE a.fk_empleado = :empleado_id AND a.fechaAlta BETWEEN :dateFrom AND :dateTo",
            nativeQuery = true)
    List<Asistencia> getByDateFrom_DateTo_Employee(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo, @Param("empleado_id") Long empleado_id);

}
