package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.presentation.dto.DTORegister;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.security.AuthenticationRequest;
import com.SIGER.SIGER.security.AuthenticationResponse;
import com.SIGER.SIGER.security.JwtService;
import com.SIGER.SIGER.security.MyUserDetailService;
import com.SIGER.SIGER.sendgrid.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.SIGER.SIGER.entities.Usuario;
import com.SIGER.SIGER.services.UsuarioServiceImpl;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	@Autowired
	private EmailService emailService;

	private final AuthenticationManager authenticationManager;

	private final MyUserDetailService myUserDetailService;

	private final JwtService jwtService;

	public UsuarioController(AuthenticationManager authenticationManager,
							 MyUserDetailService myUserDetailService, JwtService jwtService) {
		this.authenticationManager = authenticationManager;
		this.myUserDetailService = myUserDetailService;
		this.jwtService = jwtService;
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody DTORegister dtoRegister) throws IOException {
		if (dtoRegister.getUsername().equals(null)){
			return new ResponseEntity(new Mensaje("\"El campo usuario es requerido\""), HttpStatus.BAD_REQUEST);
		}
		if (dtoRegister.getCorreoInstitucional().equals(null)){
			return new ResponseEntity(new Mensaje("El campo email es requerido"), HttpStatus.BAD_REQUEST);
		}
		if ((dtoRegister.getPassword().equals(null))){
			return new ResponseEntity(new Mensaje("El campo contraseña es requerido"), HttpStatus.BAD_REQUEST);
		}
		Usuario usuario = new Usuario();
		usuario.setUsername(dtoRegister.getUsername());
		usuario.setCorreoInstitucional(dtoRegister.getCorreoInstitucional());
		usuario.setPassword(dtoRegister.getPassword());
		usuario.setRolNecesario(dtoRegister.getRolNecesario());

		usuarioServiceImpl.registrar(usuario);
		emailService.setDestinatario(usuario.getCorreoInstitucional());
		emailService.sendWelcomeEmail();
		return new ResponseEntity(new Mensaje("Usuario registrado exitosamente"), HttpStatus.OK);
	}

	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			authenticationManager.authenticate(authentication);
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid username or password", e);
		}
		UserDetails userDetails = myUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
		String token = jwtService.createToken(userDetails);
		return new AuthenticationResponse(token);
	}

	@Override
	public ResponseEntity<?> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> save(Usuario entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> update(Long id, Usuario entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
