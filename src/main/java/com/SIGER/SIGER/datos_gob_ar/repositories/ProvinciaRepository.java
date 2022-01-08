package com.SIGER.SIGER.datos_gob_ar.repositories;

import com.SIGER.SIGER.datos_gob_ar.entities.Provincia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia,String> {

  Page<Provincia> findAll(Pageable pageable);

}
