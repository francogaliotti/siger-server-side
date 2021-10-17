package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Provincia;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.ProvinciaRepository;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
@NoArgsConstructor
public class ProvinciaServiceImpl extends BaseServiceImpl<Provincia, Long> implements ProvinciaService {
	
	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	
	public ProvinciaServiceImpl(BaseRepository<Provincia, Long> baseRepository) {
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
