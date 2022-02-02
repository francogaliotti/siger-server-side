package com.SIGER.SIGER.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.model.entities.Asistencia;

@Repository
public interface AsistenciaRepository extends BaseRepository<Asistencia, Long> {

  @Query(value = "FROM Asistencia a WHERE a.empleado.id = :id")
  Page<Asistencia> findByEmpleado(@Param("id") Long id, Pageable pageable);

}
