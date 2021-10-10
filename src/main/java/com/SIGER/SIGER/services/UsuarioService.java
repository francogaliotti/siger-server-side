package com.SIGER.SIGER.services;

import com.SIGER.SIGER.entities.Usuario;

public interface UsuarioService extends BaseService<Usuario, Long>{

    public Usuario findByUsername(String username);
    public Usuario registrar(Usuario usuario);

}
