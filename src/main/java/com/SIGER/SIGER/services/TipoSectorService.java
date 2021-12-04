package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.TipoSector;
import com.SIGER.SIGER.repositories.TipoSectorRepository;
import com.SIGER.SIGER.servicesInterfaces.ITipoSectorService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoSectorService extends AbsBaseService<TipoSector, Long> implements
		ITipoSectorService {
	
	@Autowired
	TipoSectorRepository tipoSectorRepository;

	@Transactional
	public Optional<TipoSector> getByCodTipoSector(String codTipoSector) {
		return tipoSectorRepository.findByCodTipoSector(codTipoSector);
	}

	@Transactional
	public boolean existsByCodTipoSector(String codTipoSector) {
		return tipoSectorRepository.existsByCodTipoSector(codTipoSector);
	}

	@Transactional
	public Optional<TipoSector> getByNombreTipoSector(String nombreTipoSector) {
		return tipoSectorRepository.findByNombreTipoSector(nombreTipoSector);
	}

	@Transactional
	public boolean existsByNombreTipoSector(String nombreTipoSector) {
		return tipoSectorRepository.existsByNombreTipoSector(nombreTipoSector);
	}

}
