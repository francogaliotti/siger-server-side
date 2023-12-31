package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.IBoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.Boleta;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.BoletaRepository;

import java.util.Date;
import java.util.List;

@Service
public class BoletaService extends AbsBaseService<Boleta, Long> implements
    IBoletaService {
	
	@Autowired
    private BoletaRepository boletaRepository;
	
	public BoletaService(BaseRepository<Boleta, Long> baseRepository) {
        super(baseRepository);
    }


    public List<Boleta> getByDateFrom_DateTo_Employees(Date dateFrom, Date dateTo, long id){
        return boletaRepository.getByDateFrom_DateTo_Employees(dateFrom, dateTo, id);
    }
    public boolean existsById(Long id) {
        return boletaRepository.existsById(id);
    }

}
