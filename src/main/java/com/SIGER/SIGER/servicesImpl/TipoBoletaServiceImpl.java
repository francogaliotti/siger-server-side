package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.TipoBoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.TipoBoleta;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.TipoBoletaRepository;

@Service
public class TipoBoletaServiceImpl extends BaseServiceImpl<TipoBoleta, Long> implements TipoBoletaService {
	
	@Autowired
    private TipoBoletaRepository tipoBoletaRepository;
	
	public TipoBoletaServiceImpl(BaseRepository<TipoBoleta, Long> baseRepository) {
        super(baseRepository);
    }

}
