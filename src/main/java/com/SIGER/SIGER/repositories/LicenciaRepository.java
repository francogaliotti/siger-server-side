package com.SIGER.SIGER.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.model.entities.Licencia;

import java.util.Date;
import java.util.List;

@Repository
public interface LicenciaRepository extends BaseRepository<Licencia, Long>{
    @Query(value = "FROM Licencia e WHERE e.usuario.id = :id")
    List<Licencia> getByDateFrom_DateTo_Employee(Date dateFrom, Date dateTo, long id);
}
