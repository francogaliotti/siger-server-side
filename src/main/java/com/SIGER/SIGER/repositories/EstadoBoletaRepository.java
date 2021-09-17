package com.SIGER.SIGER.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.entities.EstadoBoleta;


@Repository
public interface EstadoBoletaRepository extends BaseRepository<EstadoBoleta, Long>{
	
	Optional<EstadoBoleta> findByNombreEstadoBoleta(String nombreEstadoBoleta);
	boolean existsByNombreEstadoBoleta(String nombreEstadoBoleta);

}
