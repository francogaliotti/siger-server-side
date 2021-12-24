package com.SIGER.SIGER.security.repository;

import com.SIGER.SIGER.security.entity.Rol;
import com.SIGER.SIGER.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByRolNombre(RolNombre name);
}
