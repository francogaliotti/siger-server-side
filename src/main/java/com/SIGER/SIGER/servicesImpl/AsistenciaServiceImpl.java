package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Asistencia;
import com.SIGER.SIGER.repositories.AsistenciaRepository;
import com.SIGER.SIGER.repositories.BaseRepository;

@Service
public class AsistenciaServiceImpl extends BaseServiceImpl<Asistencia, Long> implements AsistenciaService {
	
	@Autowired
    private AsistenciaRepository  asistenciaRepository;
	
	public AsistenciaServiceImpl(BaseRepository<Asistencia, Long> baseRepository) {
        super(baseRepository);
    }

}
