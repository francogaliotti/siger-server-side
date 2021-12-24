package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.model.entities.direccion.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,String> {

}
