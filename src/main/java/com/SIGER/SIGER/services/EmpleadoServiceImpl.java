package com.SIGER.SIGER.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Empleado;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado, Long> implements EmpleadoService{
	
	@Autowired
    private EmpleadoRepository empleadoRepository;
	
	public EmpleadoServiceImpl(BaseRepository<Empleado, Long> baseRepository) {
        super(baseRepository);
    }

}
