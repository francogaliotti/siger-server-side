package com.SIGER.SIGER.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.model.entities.Boleta;

import java.util.Date;
import java.util.List;

@Repository
public interface BoletaRepository extends BaseRepository<Boleta, Long>{

    @Query(value = "FROM Boleta e WHERE e.usuario.id = :id")
    List<Boleta> getByDateFrom_DateTo_Employees(Date dateFrom, Date dateTo,long id);
}
