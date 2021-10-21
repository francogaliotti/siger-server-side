package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.LicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Licencia;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.LicenciaRepository;



@Service
public class LicenciaServiceImpl extends BaseServiceImpl<Licencia, Long> implements LicenciaService {
	
	@Autowired
    private LicenciaRepository licenciaRepository;
	
	public LicenciaServiceImpl(BaseRepository<Licencia, Long> baseRepository) {
        super(baseRepository);
    }

}
