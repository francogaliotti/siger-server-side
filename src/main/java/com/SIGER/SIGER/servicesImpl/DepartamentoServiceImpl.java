package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Departamento;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.DepartamentoRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class DepartamentoServiceImpl extends BaseServiceImpl<Departamento, Long> implements DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	
	public DepartamentoServiceImpl(BaseRepository<Departamento, Long> baseRepository) {
      super(baseRepository);
  }

}
