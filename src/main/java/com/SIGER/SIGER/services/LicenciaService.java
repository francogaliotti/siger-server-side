package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.ILicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.Licencia;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.LicenciaRepository;

import java.util.Date;
import java.util.List;


@Service
public class LicenciaService extends AbsBaseService<Licencia, Long> implements
    ILicenciaService {
	
	@Autowired
    private LicenciaRepository licenciaRepository;
	
	public LicenciaService(BaseRepository<Licencia, Long> baseRepository) {
        super(baseRepository);
    }

    public List<Licencia> getByDateFrom_DateTo_Employee(Date dateFrom, Date dateTo, long id){
        return licenciaRepository.getByDateFrom_DateTo_Employee(dateFrom, dateTo, id);
    }
    public boolean existsById(Long id) {
        return licenciaRepository.existsById(id);
    }

}
