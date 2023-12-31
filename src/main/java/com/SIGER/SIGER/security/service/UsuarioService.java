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

    public Optional<Usuario>getByUserId(Long userId){
        return usuarioRepository.findById(userId);
    }

    public Optional<Usuario>getByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    public Optional<Usuario>findByTokenPassword(String tokenPassword){
        return usuarioRepository.findByTokenPassword(tokenPassword);
    }

    public Optional<Usuario> getByUsernameOrCorreoInstitucional(String usernameOrCorreoInstitucional){
        return usuarioRepository.findByUsernameOrCorreoInstitucional(usernameOrCorreoInstitucional, usernameOrCorreoInstitucional);
    }

    public boolean existsByUsername(String username){
        return usuarioRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String correoInstitucional){
        return usuarioRepository.existsByCorreoInstitucional(correoInstitucional);
    }
    public void save (Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
