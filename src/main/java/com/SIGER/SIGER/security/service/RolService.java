package com.SIGER.SIGER.security.service;

import com.SIGER.SIGER.security.entity.Rol;
import com.SIGER.SIGER.security.enums.RolNombre;
import com.SIGER.SIGER.security.repository.RolRepository;
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
}
