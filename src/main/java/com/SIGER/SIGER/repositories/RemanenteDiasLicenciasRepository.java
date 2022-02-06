package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.model.entities.RemanenteDiasLicencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RemanenteDiasLicenciasRepository extends JpaRepository<RemanenteDiasLicencia,Long> {

    @Query(value = "FROM RemanenteDiasLicencia l WHERE l.tipoLicencia.id = :id")
    RemanenteDiasLicencia findByTipoLicencia(@Param("id") Long id);

}
