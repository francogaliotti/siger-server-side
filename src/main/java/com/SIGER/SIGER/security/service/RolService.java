package com.SIGER.SIGER.security.service;

import com.SIGER.SIGER.security.entity.Rol;
import com.SIGER.SIGER.security.enums.RolNombre;
import com.SIGER.SIGER.security.repository.RolRepository;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save (Rol rol){
        rolRepository.save(rol);
    }
    public void delete (Long id){
        Rol rol = rolRepository.getById(id);
        rolRepository.delete(rol);
    }

    public List<Rol> list(){
        return rolRepository.findAll();
    }
   /* public Optional<Rol> getByNombreRol(String rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }*/
    public boolean existByNombreRol(String nombre){
        return rolRepository.existsByRolNombre(nombre);
    }
    public boolean existsById (Long id) {
        return rolRepository.existsById(id);
    }
    public Optional<Rol> getById(Long id){
        return rolRepository.findById(id);
    }
}
