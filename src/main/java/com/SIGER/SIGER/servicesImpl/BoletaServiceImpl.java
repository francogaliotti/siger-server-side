package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.BoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Boleta;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.BoletaRepository;

@Service
public class BoletaServiceImpl extends BaseServiceImpl<Boleta, Long> implements BoletaService {
	
	@Autowired
    private BoletaRepository boletaRepository;
	
	public BoletaServiceImpl(BaseRepository<Boleta, Long> baseRepository) {
        super(baseRepository);
    }

}
