package com.SIGER.SIGER.security.repository;

import com.SIGER.SIGER.security.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByUsernameOrCorreoInstitucional(String username, String correoInstitucional);
    Optional<Usuario> findByTokenPassword(String tokenPassword);
    boolean existsByUsername(String username);
    boolean existsByCorreoInstitucional(String correoInstitucional);
}
