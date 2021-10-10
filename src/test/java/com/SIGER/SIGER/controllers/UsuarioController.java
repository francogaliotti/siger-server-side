package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.presentation.dto.DTORegister;
import com.SIGER.SIGER.security.AuthenticationRequest;
import com.SIGER.SIGER.security.AuthenticationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioController {

    @Autowired
    private UsuarioController usuarioController;

    @Test
    public void  registrarUsuario() throws IOException {
        DTORegister dtoRegister = DTORegister.builder().username("DPV").password("1234")
                .correoInstitucional("max00m_e139b@gexik.com").rolNecesario("Admin").build();
        ResponseEntity usuarioTest = usuarioController.register(dtoRegister);

        assertTrue(usuarioTest.getStatusCode().is2xxSuccessful());

    }

    @Test
    public void loginUsuario() throws Exception {
        //La primera ejecucion puede fallar por ejecutarse antes que registrarUsuario() y no haber datos cargados
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("DPV","1234");
        AuthenticationResponse authenticationResponse = usuarioController.login(authenticationRequest);

        assertTrue(!authenticationResponse.getToken().isEmpty());

    }

}
