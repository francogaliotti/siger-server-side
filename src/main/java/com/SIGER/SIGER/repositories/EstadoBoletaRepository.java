package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.model.entities.EstadoBoleta;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoBoletaRepository extends BaseRepository<EstadoBoleta, Long>{
	
	Optional<EstadoBoleta> findByNombreEstadoBoleta(String nombreEstadoBoleta);
	boolean existsByNombreEstadoBoleta(String nombreEstadoBoleta);

}
