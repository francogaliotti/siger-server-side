package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.Departamento;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.DepartamentoRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class DepartamentoService extends AbsBaseService<Departamento, Long> implements
		IDepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	
	public DepartamentoService(BaseRepository<Departamento, Long> baseRepository) {
      super(baseRepository);
  }

}
