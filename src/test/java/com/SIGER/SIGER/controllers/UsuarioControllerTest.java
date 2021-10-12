package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.security.controller.AuthController;
import com.SIGER.SIGER.security.dto.JwtDTO;
import com.SIGER.SIGER.security.dto.LoginUsuario;
import com.SIGER.SIGER.security.dto.NuevoUsuario;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UsuarioControllerTest {

    @Autowired
    private AuthController authController;

    @Mock
    private BindingResult mockBindingResult;

   /* @Test
    public void  registrarUsuario() throws IOException {

        NuevoUsuario nuevoUsuario = NuevoUsuario.builder().username("DPV").password("1234")
                .email("alexbahi.99@gmail.com").build();
        ResponseEntity usuarioTest = authController.register(nuevoUsuario,mockBindingResult);

        assertTrue(usuarioTest.getStatusCode().is2xxSuccessful());

    }

    @Test
    public void loginUsuario() throws Exception {
        //La primera ejecucion puede fallar por ejecutarse antes que registrarUsuario() y no haber datos cargados

        LoginUsuario loginUsuario = new LoginUsuario("DPV","1234");
        ResponseEntity<JwtDTO> jwtDTOResponseEntity = authController.login(loginUsuario, mockBindingResult);

        assertTrue(jwtDTOResponseEntity.getStatusCode().is2xxSuccessful());

    }*/

}
