package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.TipoLicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.TipoLicencia;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.TipoLicenciaRepository;

@Service
public class TipoLicenciaServiceImpl extends BaseServiceImpl<TipoLicencia, Long> implements TipoLicenciaService {
	
	@Autowired
    private TipoLicenciaRepository tipoLicenciaRepository;
	
	public TipoLicenciaServiceImpl(BaseRepository<TipoLicencia, Long> baseRepository) {
        super(baseRepository);
    }

}
