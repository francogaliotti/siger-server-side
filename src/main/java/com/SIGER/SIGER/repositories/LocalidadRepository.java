package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.model.entities.direccion.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad,String> {

}
