/*package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.presentation.dto.DTORegister;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.sendgrid.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;

public class UsuarioExpert {

    public ResponseEntity<?> register(DTORegister dtoRegister, UsuarioServiceImpl usuarioServiceImpl, EmailService emailService) throws IOException {

        Mensaje mensaje = new Mensaje("Usuario registrado exitosamente");
        HttpStatus httpStatus = HttpStatus.OK;

        if (dtoRegister.getUsername().equals(null)){
            mensaje.setMensaje("El campo usuario es requerido");
            httpStatus = HttpStatus.BAD_REQUEST;

        }
        if (dtoRegister.getCorreoInstitucional().equals(null)){
            mensaje.setMensaje("El campo email es requerido");
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        if ((dtoRegister.getPassword().equals(null))){
            mensaje.setMensaje("El campo contraseña es requerido");
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        Usuario usuario = new Usuario();
        usuario.setUsername(dtoRegister.getUsername());
        usuario.setCorreoInstitucional(dtoRegister.getCorreoInstitucional());
        usuario.setPassword(dtoRegister.getPassword());
        usuario.setRolNecesario(dtoRegister.getRolNecesario());

        usuarioServiceImpl.registrar(usuario);
        sendEmail(usuario, emailService);

        return new ResponseEntity(mensaje, httpStatus);

    }

    public void sendEmail(Usuario usuario, EmailService emailService) throws IOException {

        emailService.setDestinatario(usuario.getCorreoInstitucional());
        emailService.sendWelcomeEmail();
    }

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest,AuthenticationManager authenticationManager,
                                        MyUserDetailService myUserDetailService, JwtService jwtService, UsuarioServiceImpl usuarioServiceImpl) throws Exception {

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

}*/
