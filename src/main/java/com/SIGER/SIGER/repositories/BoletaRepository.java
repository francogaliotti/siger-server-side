package com.SIGER.SIGER.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.model.entities.Boleta;

import java.util.Date;
import java.util.List;

@Repository
public interface BoletaRepository extends BaseRepository<Boleta, Long>{

    @Query(value = "SELECT * FROM Boleta b WHERE b.fk_empleado = :empleado_id AND b.fechaAlta BETWEEN :dateFrom AND :dateTo",
            nativeQuery = true)
    List<Boleta> getByDateFrom_DateTo_Employees(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo, @Param("empleado_id") Long empleado_id);
}
