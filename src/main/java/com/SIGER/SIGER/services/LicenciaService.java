package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.ILicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.Licencia;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.LicenciaRepository;



@Service
public class LicenciaService extends AbsBaseService<Licencia, Long> implements
    ILicenciaService {
	
	@Autowired
    private LicenciaRepository licenciaRepository;
	
	public LicenciaService(BaseRepository<Licencia, Long> baseRepository) {
        super(baseRepository);
    }

    public boolean existsById(Long id) {
        return licenciaRepository.existsById(id);
    }

}
