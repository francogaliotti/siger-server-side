package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.entities.Permiso;

import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.PermisoRepository;

import com.SIGER.SIGER.services.PermisoService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
@NoArgsConstructor
public class PermisoServiceImpl extends BaseServiceImpl<Permiso, Long> implements PermisoService {
    @Autowired
    private PermisoRepository permisoRepository;


    public PermisoServiceImpl(BaseRepository<Permiso, Long> baseRepository) {
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
