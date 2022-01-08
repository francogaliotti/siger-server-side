package com.SIGER.SIGER.datos_gob_ar.repositories;

import com.SIGER.SIGER.datos_gob_ar.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad,String> {

  @Query(value = "SELECT * FROM localidades l WHERE l.provincia_id = :provincia_id",
      nativeQuery = true)
  Page<Localidad> findByProvincia(Pageable pageable, @Param("provincia_id") Long id);

  @Query(value = "SELECT * FROM localidades l WHERE l.departamento_id = :departamento_id",
      nativeQuery = true)
  Page<Localidad> findByDepartamento(Pageable pageable, @Param("departamento_id") Long id);

  @Query(value = "SELECT * FROM localidades l WHERE l.municipio_id = :municipio_id",
      nativeQuery = true)
  Page<Localidad> findByMunicipio(Pageable pageable, @Param("municipio_id") Long id);

}
