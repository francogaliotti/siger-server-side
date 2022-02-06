package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.model.entities.Asistencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AsistenciaRepository extends BaseRepository<Asistencia, Long> {

  @Query(value = "FROM Asistencia a WHERE a.empleado.id = :id")
  Page<Asistencia> findByEmpleado(@Param("id") Long id, Pageable pageable);

  @Query(value = "SELECT * FROM Asistencia a WHERE a.fk_empleado = :empleado_id AND a.fechaAlta BETWEEN :dateFrom AND :dateTo",
          nativeQuery = true)
  List<Asistencia> findByFechaAlta(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo, @Param("empleado_id") Long empleado_id);

}
