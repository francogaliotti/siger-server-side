package com.SIGER.SIGER.security.seeder;

import com.SIGER.SIGER.security.seeder.config.ApplicationRole;
import com.SIGER.SIGER.security.entity.Rol;
import com.SIGER.SIGER.security.entity.Usuario;
import com.SIGER.SIGER.security.repository.RolRepository;
import com.SIGER.SIGER.security.repository.UsuarioRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsersSeeder implements CommandLineRunner {

  private static final String PHOTO = "https://foo.jpg";
  private static final long ROLE_USER = 1L;
  private static final long ROLE_ADMIN = 2L;
  private static final String PASSWORD_GENERIC = "siger1234";

  @Autowired
  UsuarioRepository userRepository;

  @Autowired
  RolRepository roleRepository;

  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public void run(String... args) throws Exception {
    loadRoles();
    loadUsers();
  }

  private void loadRoles() {
    if (roleRepository.count() == 0) {
      roleRepository.save(buildRole(ApplicationRole.USER));
      roleRepository.save(buildRole(ApplicationRole.ADMIN));
    }
  }

  private Rol buildRole(ApplicationRole applicationRole) {
    Rol role = new Rol();
    role.setId(getRoleId(applicationRole));
    role.setRolNombre(applicationRole.getFullRoleName());
    return role;
  }

  private long getRoleId(ApplicationRole applicationRole) {
    return applicationRole == ApplicationRole.USER ? ROLE_USER : ROLE_ADMIN;
  }

  private void loadUsers() {
    if (userRepository.count() == 0) {
      loadUsersWithRoleUser();
      loadUsersWithRoleAdmin();
    }
  }

  private void loadUsersWithRoleUser() {
    userRepository.save(buildUser("Jeremias Fernandez", "JFernandez", "jfernandez@siger.com"));
    userRepository.save(buildUser( "Alexis Bahi", "ABahi", "abahi@siger.com"));
    userRepository.save(buildUser( "Franco Galiotti", "FGaliotti", "fgaliotti@siger.com"));
    userRepository.save(buildUser( "Diego Villa", "DVilla", "dvilla@siger.com"));
  }

  private void loadUsersWithRoleAdmin() {
    userRepository.save(buildUserAdmin("Jeremias Fernandez", "Jeremias.Fernandez", "fernandez.jeremias.daniel@gmail.com"));
    userRepository.save(buildUserAdmin( "Alexis Bahi", "Alexis.Bahi", "abahi.99@gmail.com"));
    userRepository.save(buildUserAdmin( "Franco Galiotti", "Franco.Galiotti", "francogaliotti@gmail.com"));
    userRepository.save(buildUserAdmin( "Diego Villa", "Diego.Villa", "diegovillautnfrm@gmail.com"));
  }

  private Usuario buildUser(String nombre, String username, String email) {
    return Usuario.builder()
        .nombre(nombre)
        .username(username)
        .email(email)
        .password(bCryptPasswordEncoder.encode(PASSWORD_GENERIC))
        .roles(Set.of(roleRepository.findById(ROLE_USER).get()))
        .build();
  }

  private Usuario buildUserAdmin(String nombre, String username, String email) {
    return Usuario.builder()
        .nombre(nombre)
        .username(username)
        .email(email)
        .password(bCryptPasswordEncoder.encode(PASSWORD_GENERIC))
        .roles(Set.of(roleRepository.findById(ROLE_USER).get()))
        .build();
  }

}
