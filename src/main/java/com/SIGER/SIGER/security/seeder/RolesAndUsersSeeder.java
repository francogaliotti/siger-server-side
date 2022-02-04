package com.SIGER.SIGER.security.seeder;

import com.SIGER.SIGER.security.entity.Rol;
import com.SIGER.SIGER.security.entity.Usuario;
import com.SIGER.SIGER.security.enums.RolNombre;
import com.SIGER.SIGER.security.repository.RolRepository;
import com.SIGER.SIGER.security.repository.UsuarioRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RolesAndUsersSeeder implements CommandLineRunner {

  private static final long ROLE_USER = 1L;
  private static final long ROLE_ADMIN = 2L;
  private static final String PASSWORD_GENERIC = "siger1234";

  @Autowired
  UsuarioRepository usuarioRepository;

  @Autowired
  RolRepository rolRepository;

  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public void run(String... args) throws Exception {
    loadRoles();
    loadUsers();
  }

  private void loadRoles() {
    if (rolRepository.count() == 0) {
      rolRepository.save(buildRole(RolNombre.USER));
      rolRepository.save(buildRole(RolNombre.ADMIN));
    }
  }

  private Rol buildRole(RolNombre applicationRole) {
    Rol role = new Rol();
    role.setRolNombre(applicationRole.getFullRoleName());
    return role;
  }

  private void loadUsers() {
    if (usuarioRepository.count() == 0) {
      loadUsersWithRoleUser();
      loadUsersWithRoleAdmin();
    }
  }

  private void loadUsersWithRoleUser() {
    usuarioRepository.save(buildUser("Jeremias Fernandez", "JFernandez", "jfernandez@siger.com",
        "assets/images/Jeremias.Fernandez.jpg"));
    usuarioRepository.save(buildUser("Alexis Bahi", "ABahi", "abahi@siger.com",
        "assets/images/Alexis.Bahi.jpg"));
    usuarioRepository.save(buildUser("Franco Galiotti", "FGaliotti", "fgaliotti@siger.com",
        "assets/images/Franco.Galiotti.jpeg"));
    usuarioRepository.save(buildUser("Diego Villa", "DVilla", "dvilla@siger.com",
        "assets/images/Diego.Villa.png"));
  }

  private void loadUsersWithRoleAdmin() {
    usuarioRepository.save(buildUserAdmin("Jeremias Fernandez", "Jeremias.Fernandez",
        "fernandez.jeremias.daniel@gmail.com", "assets/images/Jeremias.Fernandez.jpg"));
    usuarioRepository.save(buildUserAdmin("Alexis Bahi", "Alexis.Bahi", "abahi.99@gmail.com",
        "assets/images/Alexis.Bahi.jpg"));
    usuarioRepository.save(
        buildUserAdmin("Franco Galiotti", "Franco.Galiotti", "francogaliotti@gmail.com",
            "assets/images/Franco.Galiotti.jpeg"));
    usuarioRepository.save(
        buildUserAdmin("Diego Villa", "Diego.Villa", "diegovillautnfrm@gmail.com",
            "assets/images/Diego.Villa.png"));
  }

  private Usuario buildUser(String nombre, String username, String email, String image) {
    return Usuario.builder()
        .nombre(nombre)
        .username(username)
        .correoInstitucional(email)
        .password(bCryptPasswordEncoder.encode(PASSWORD_GENERIC))
        .image(image)
        .roles(Set.of(rolRepository.findById(ROLE_USER).get()))
        .build();
  }

  private Usuario buildUserAdmin(String nombre, String username, String email, String image) {
    return Usuario.builder()
        .nombre(nombre)
        .username(username)
        .correoInstitucional(email)
        .password(bCryptPasswordEncoder.encode(PASSWORD_GENERIC))
        .image(image)
        .roles(Set.of(rolRepository.findById(ROLE_ADMIN).get()))
        .build();
  }

}
