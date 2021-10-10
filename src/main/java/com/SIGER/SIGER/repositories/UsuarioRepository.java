package com.SIGER.SIGER.repositories;

import org.springframework.stereotype.Repository;

import com.SIGER.SIGER.entities.Usuario;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long>{

    public Usuario findByUsername(String username);

}