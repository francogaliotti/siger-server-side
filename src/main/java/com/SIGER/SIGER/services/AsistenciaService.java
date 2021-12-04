package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.Asistencia;
import com.SIGER.SIGER.repositories.AsistenciaRepository;
import com.SIGER.SIGER.repositories.BaseRepository;

@Service
public class AsistenciaService extends AbsBaseService<Asistencia, Long> implements
    IAsistenciaService {
	
	@Autowired
    private AsistenciaRepository  asistenciaRepository;
	
	public AsistenciaService(BaseRepository<Asistencia, Long> baseRepository) {
        super(baseRepository);
    }

}
