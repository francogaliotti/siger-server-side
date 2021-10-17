/*package com.SIGER.SIGER.services;

import com.SIGER.SIGER.entities.EstadoBoleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Rol;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.RolRepository;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
@NoArgsConstructor
public class RolServiceImpl extends BaseServiceImpl<Rol, Long> implements RolService{
	
	@Autowired
	private RolRepository rolRepository;
	
	
	public RolServiceImpl(BaseRepository<Rol, Long> baseRepository) {
      super(baseRepository);
    }
	public List<Rol> list(){
		return rolRepository.findAll();
	}
	public Optional<Rol> getByNombreRol(String nombreRol){
		return rolRepository.findByNombreRol(nombreRol);
	}
	public boolean existByNombreRol(String nombre){
		return rolRepository.existsByNombreRol(nombre);
	}
	public boolean existsById (Long id) {
		return rolRepository.existsById(id);
	}
	public Optional<Rol> getById(Long id){
		return rolRepository.findById(id);
	}


}*/
