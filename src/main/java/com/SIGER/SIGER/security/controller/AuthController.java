package com.SIGER.SIGER.security.controller;

import com.SIGER.SIGER.security.dto.JwtDTO;
import com.SIGER.SIGER.security.dto.LoginUsuario;
import com.SIGER.SIGER.security.dto.NuevoUsuario;
import com.SIGER.SIGER.security.expert.AuthExpert;
import java.text.ParseException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    AuthExpert authExpert;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        return authExpert.register(nuevoUsuario, bindingResult);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        return authExpert.login(loginUsuario, bindingResult);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtDTO> refreshToken(@RequestBody JwtDTO jwtDTO) throws ParseException {
        return authExpert.refreshToken(jwtDTO);
    }

}