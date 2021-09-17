package com.SIGER.SIGER.repositories;

import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.entities.Rol;

import java.util.Optional;

@Repository
public interface RolRepository extends BaseRepository<Rol, Long>{
    Optional<Rol> findByNombreRol(String nombreRol);
    boolean existsByNombreRol(String nombreRol);
}
