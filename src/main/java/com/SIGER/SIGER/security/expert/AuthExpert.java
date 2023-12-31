package com.SIGER.SIGER.security.expert;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.security.dto.JwtDTO;
import com.SIGER.SIGER.security.dto.LoginUsuario;
import com.SIGER.SIGER.security.dto.NuevoUsuario;
import com.SIGER.SIGER.security.entity.Rol;
import com.SIGER.SIGER.security.entity.Usuario;
import com.SIGER.SIGER.security.enums.RolNombre;
import com.SIGER.SIGER.security.jwt.JwtProvider;
import com.SIGER.SIGER.security.service.RolService;
import com.SIGER.SIGER.security.service.UsuarioService;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class AuthExpert {

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UsuarioService usuarioService;

  @Autowired
  RolService rolService;

  @Autowired
  JwtProvider jwtProvider;

  public ResponseEntity<?> register(NuevoUsuario nuevoUsuario, BindingResult bindingResult){
    if(bindingResult.hasErrors())
      return new ResponseEntity(new Message("Campos o email inválidos"), HttpStatus.BAD_REQUEST);
    if(usuarioService.existsByUsername(nuevoUsuario.getUsername()))
      return new ResponseEntity(new Message("Nombre de Usuario ya está registrado"), HttpStatus.BAD_REQUEST);
    /*if(usuarioService.existsByEmail(nuevoUsuario.getCorreoInstitucional()))
      return new ResponseEntity(new Message("Correo ya está registrado"), HttpStatus.BAD_REQUEST);*/
    Usuario usuario = Usuario.builder().nombre(nuevoUsuario.getNombre()).username(nuevoUsuario.getUsername())
        .correoInstitucional(nuevoUsuario.getCorreoInstitucional()).password(passwordEncoder.encode(nuevoUsuario.getPassword())).build();
    Set<Rol> roles = new HashSet<>();
    roles.add(rolService.getByRolNombre(RolNombre.USER).get());
    if(nuevoUsuario.getRoles().contains("admin"))
      roles.add(rolService.getByRolNombre(RolNombre.ADMIN).get());
    usuario.setRoles(roles);
    usuarioService.save(usuario);
    return new ResponseEntity(new Message("Usuario creado satisfactoriamente"), HttpStatus.CREATED);
  }

  public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
    if(bindingResult.hasErrors())
      return new ResponseEntity(new Message("Campos inválidos"), HttpStatus.BAD_REQUEST);
    Authentication authentication =
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
            (loginUsuario.getUsername(),loginUsuario.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    Optional<Usuario> usuario = usuarioService.getByUsername(loginUsuario.getUsername());
    if (!usuario.get().isEnabled())
      return new ResponseEntity(new Message("Su cuenta ha sido deshabilitada"), HttpStatus.BAD_REQUEST);
    /*if (usuario.get().getPasswordExpireDate().isBefore(LocalDateTime.now()))
      return new ResponseEntity(new Message("Su contraseña ha expirado, por favor cámbiela"), HttpStatus.BAD_REQUEST);*/
    String jwt = jwtProvider.generateToken(authentication,usuario.get().getId());
    JwtDTO jwtDTO = new JwtDTO(jwt);
    return new ResponseEntity(jwtDTO, HttpStatus.OK);
  }

  public ResponseEntity<JwtDTO> refreshToken(@RequestBody JwtDTO jwtDTO) throws ParseException {
    String token = jwtProvider.refreshToken(jwtDTO);
    JwtDTO jwt = new JwtDTO(token);
    return new ResponseEntity<>(jwt, HttpStatus.OK);
  }

  public Boolean getSigninStatus(String username){
    Optional<Usuario> optionalUser = usuarioService.getByUsername(username);
    Usuario user = null;
    if(optionalUser.isPresent()){
      user = optionalUser.get();
    }

    return user.isFirstSignin();
  }

  public ResponseEntity<Usuario> getByUserId(Long userId){
    Optional<Usuario> optionalUser = usuarioService.getByUserId(userId);
    return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
  }

  public Boolean existByUsername(String username){
    return usuarioService.existsByUsername(username);
  }

}
