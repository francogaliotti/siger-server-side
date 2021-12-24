package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.Permiso;

import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.PermisoRepository;

import com.SIGER.SIGER.servicesInterfaces.IPermisoService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
@NoArgsConstructor
public class PermisoService extends AbsBaseService<Permiso, Long> implements
    IPermisoService {
    @Autowired
    private PermisoRepository permisoRepository;


    public PermisoService(BaseRepository<Permiso, Long> baseRepository) {
        super(baseRepository);
    }
    public List<Permiso> list(){
        return permisoRepository.findAll();
    }
    public Optional<Permiso> getByNombrePermiso(String nombreRol){
        return permisoRepository.findByNombrePermiso(nombreRol);
    }
    public boolean existByNombrePermiso(String nombre){
        return permisoRepository.existsByNombrePermiso(nombre);
    }
    public boolean existsById (Long id) {
        return permisoRepository.existsById(id);
    }
    public Optional<Permiso> getById(Long id){
        return permisoRepository.findById(id);
    }
}
