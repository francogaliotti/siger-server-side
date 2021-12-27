package com.SIGER.SIGER.security.seeder;

import com.SIGER.SIGER.security.entity.Rol;
import com.SIGER.SIGER.security.entity.Usuario;
import com.SIGER.SIGER.security.enums.RolNombre;
import com.SIGER.SIGER.security.repository.RolRepository;
import com.SIGER.SIGER.security.repository.UsuarioRepository;
//import com.SIGER.SIGER.security.seeder.config.ApplicationRole;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RolesAndUsersSeeder implements CommandLineRunner {

  //private static final String PHOTO = "https://foo.jpg";
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

  /*private long getRoleId(ApplicationRole applicationRole) {
    return applicationRole == ApplicationRole.USER ? ROLE_USER : ROLE_ADMIN;
  }*/

  private void loadUsers() {
    if (usuarioRepository.count() == 0) {
      loadUsersWithRoleUser();
      loadUsersWithRoleAdmin();
    }
  }

  private void loadUsersWithRoleUser() {
    usuarioRepository.save(buildUser("Jeremias Fernandez", "JFernandez", "jfernandez@siger.com"));
    usuarioRepository.save(buildUser("Alexis Bahi", "ABahi", "abahi@siger.com"));
    usuarioRepository.save(buildUser("Franco Galiotti", "FGaliotti", "fgaliotti@siger.com"));
    usuarioRepository.save(buildUser("Diego Villa", "DVilla", "dvilla@siger.com"));
  }

  private void loadUsersWithRoleAdmin() {
    usuarioRepository.save(buildUserAdmin("Jeremias Fernandez", "Jeremias.Fernandez",
        "fernandez.jeremias.daniel@gmail.com"));
    usuarioRepository.save(buildUserAdmin("Alexis Bahi", "Alexis.Bahi", "abahi.99@gmail.com"));
    usuarioRepository.save(
        buildUserAdmin("Franco Galiotti", "Franco.Galiotti", "francogaliotti@gmail.com"));
    usuarioRepository.save(
        buildUserAdmin("Diego Villa", "Diego.Villa", "diegovillautnfrm@gmail.com"));
  }

  private Usuario buildUser(String nombre, String username, String email) {
    return Usuario.builder()
        .nombre(nombre)
        .username(username)
        .email(email)
        .password(bCryptPasswordEncoder.encode(PASSWORD_GENERIC))
        .roles(Set.of(rolRepository.findById(ROLE_USER).get()))
        .build();
  }

  private Usuario buildUserAdmin(String nombre, String username, String email) {
    return Usuario.builder()
        .nombre(nombre)
        .username(username)
        .email(email)
        .password(bCryptPasswordEncoder.encode(PASSWORD_GENERIC))
        .roles(Set.of(rolRepository.findById(ROLE_ADMIN).get()))
        .build();
  }

}