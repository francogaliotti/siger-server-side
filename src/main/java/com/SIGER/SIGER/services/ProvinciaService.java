package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.IProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.Provincia;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.ProvinciaRepository;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
@NoArgsConstructor
public class ProvinciaService extends AbsBaseService<Provincia, Long> implements
		IProvinciaService {
	
	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	
	public ProvinciaService(BaseRepository<Provincia, Long> baseRepository) {
      super(baseRepository);
  }
	public List<Provincia> list(){
		return provinciaRepository.findAll();
	}
	public Optional<Provincia> getByDenominacion(String denominacion){
		return provinciaRepository.findByDenominacion(denominacion);
	}
	public boolean existByDenominacion(String den){
		return provinciaRepository.existsByDenominacion(den);
	}
	public boolean existsById (Long id) {
		return provinciaRepository.existsById(id);
	}
	public Optional<Provincia> getById(Long id){
		return provinciaRepository.findById(id);
	}

}
