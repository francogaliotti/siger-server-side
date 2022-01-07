package com.SIGER.SIGER.datos_gob_ar.repositories;

import com.SIGER.SIGER.datos_gob_ar.entities.Municipio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio,String> {

  @Query(value = "SELECT * FROM departamentos d WHERE d.provincia_id = :provincia_id",
      nativeQuery = true)
  Page<Municipio> findByProvincia(Pageable pageable, @Param("provincia_id") Long id);

}
