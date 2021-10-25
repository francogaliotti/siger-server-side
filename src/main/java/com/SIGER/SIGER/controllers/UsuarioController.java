/*package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.UsuarioExpert;
import com.SIGER.SIGER.presentation.dto.DTORegister;
import com.SIGER.SIGER.sendgrid.EmailSendGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import com.SIGER.SIGER.entities.Usuario;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	@Autowired
	EmailSendGridService emailService;

	private final AuthenticationManager authenticationManager;

	private final MyUserDetailService myUserDetailService;

	private final JwtService jwtService;

	public UsuarioController(AuthenticationManager authenticationManager,
						 MyUserDetailService myUserDetailService, JwtService jwtService) {
		this.authenticationManager = authenticationManager;
		this.myUserDetailService = myUserDetailService;
		this.jwtService = jwtService;
	}

	//@Autowired
	UsuarioExpert usuarioExpert = new UsuarioExpert();

	@PostMapping("/signin")
	public ResponseEntity<?> register(@RequestBody DTORegister dtoRegister) throws IOException {
		return usuarioExpert.register(dtoRegister, usuarioServiceImpl, emailService);
	}

	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		return usuarioExpert.login(authenticationRequest,authenticationManager,myUserDetailService,jwtService, usuarioServiceImpl);
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

}*/
