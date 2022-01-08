package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.model.entities.Empleado;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado, Long>{

  Optional<Empleado> findByNombre(String nombre);
  boolean existsByNombre(String nombre);

  Optional<Empleado> findByApellido(String apellido);
  boolean existsByApellido(String apellido);

  Optional<Empleado> findByLegajo(int legajo);
  boolean existsByLegajo(int legajo);

  @Query(value = "FROM Empleado e WHERE e.usuario.id = :id")
  Empleado findByUsuario(@Param("id") Long id);

}
