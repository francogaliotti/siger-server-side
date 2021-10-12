package com.SIGER.SIGER.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Viatico;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.ViaticoRepository;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
@NoArgsConstructor
public class ViaticoServiceImpl extends BaseServiceImpl<Viatico, Long> implements ViaticoService{
	
	@Autowired
	private ViaticoRepository viaticoRepository;
	
	
	public ViaticoServiceImpl(BaseRepository<Viatico, Long> baseRepository) {
      super(baseRepository); }

	public List<Viatico> list(){
		return viaticoRepository.findAll();
	}
	public Optional<Viatico> getByCodViatico(String codViatico){
		return viaticoRepository.findByCodViatico(codViatico);
	}
	public boolean existByCodViatico(String nombre){
		return viaticoRepository.existsByCodViatico(nombre);
	}
	public boolean existsById (Long id) {
		return viaticoRepository.existsById(id);
	}
	public Optional<Viatico> getById(Long id){
		return viaticoRepository.findById(id);
	}


}
