package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.model.entities.Empleado;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado, Long>{

  Optional<Empleado> findByNombre(String nombre);
  boolean existsByNombre(String nombre);

  Optional<Empleado> findByApellido(String apellido);
  boolean existsByApellido(String apellido);

  Optional<Empleado> findByLegajo(int legajo);
  boolean existsByLegajo(int legajo);

  Optional<Empleado> findByCuil(String cuil);
  boolean existsByCuil(String cuil);

  Optional<Empleado> findByNroIdentificacionPersonal(String nroIdentificacionPersonal);
  boolean existsByNroIdentificacionPersonal(String nroIdentificacionPersonal);

}
