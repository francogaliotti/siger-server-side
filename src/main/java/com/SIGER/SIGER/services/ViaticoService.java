package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.IViaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.Viatico;
import com.SIGER.SIGER.repositories.ViaticoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ViaticoService extends AbsBaseService<Viatico, Long> implements
		IViaticoService {
	
	@Autowired
	ViaticoRepository viaticoRepository;

	public List<Viatico> list(){
		return viaticoRepository.findAll();
	}

	public Optional<Viatico> getById(Long id){
		return viaticoRepository.findById(id);
	}

	public Optional<Viatico> getByCodViatico(String codViatico){
		return viaticoRepository.findByCodViatico(codViatico);
	}

	public Optional<Viatico> getByDenominacionViatico(String denominacionViatico){
		return viaticoRepository.findByDenominacionViatico(denominacionViatico);
	}

	public boolean existsById (Long id) {
		return viaticoRepository.existsById(id);
	}

	public boolean existByCodViatico(String nombre){
		return viaticoRepository.existsByCodViatico(nombre);
	}

	public boolean existByDenominacionViatico(String denominacionViatico){
		return viaticoRepository.existsByDenominacionViatico(denominacionViatico);
	}

}
