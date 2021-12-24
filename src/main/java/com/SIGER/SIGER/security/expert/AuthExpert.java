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
import java.util.HashSet;
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
    if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
      return new ResponseEntity(new Message("Correo ya está registrado"), HttpStatus.BAD_REQUEST);
    Usuario usuario = Usuario.builder().nombre(nuevoUsuario.getNombre()).username(nuevoUsuario.getUsername())
        .email(nuevoUsuario.getEmail()).password(passwordEncoder.encode(nuevoUsuario.getPassword())).build();
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
    String jwt = jwtProvider.generateToken(authentication);
    JwtDTO jwtDTO = new JwtDTO(jwt);
    return new ResponseEntity(jwtDTO, HttpStatus.OK);
  }

  public ResponseEntity<JwtDTO> refreshToken(@RequestBody JwtDTO jwtDTO) throws ParseException {
    String token = jwtProvider.refreshToken(jwtDTO);
    JwtDTO jwt = new JwtDTO(token);
    return new ResponseEntity<>(jwt, HttpStatus.OK);
  }

}
