package com.SIGER.SIGER.security.service;

import com.SIGER.SIGER.security.entity.Usuario;
import com.SIGER.SIGER.security.repository.UsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario>getByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    public Optional<Usuario>findByTokenPassword(String tokenPassword){
        return usuarioRepository.findByTokenPassword(tokenPassword);
    }

    public Optional<Usuario>getByUsernameOrEmail(String usernameOrEmail){
        return usuarioRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
    }

    public boolean existsByUsername(String username){
        return usuarioRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }
    public void save (Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
