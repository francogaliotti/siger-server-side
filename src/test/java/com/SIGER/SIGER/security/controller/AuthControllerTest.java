package com.SIGER.SIGER.security.controller;

import com.SIGER.SIGER.security.dto.JwtDTO;
import com.SIGER.SIGER.security.dto.LoginUsuario;
import com.SIGER.SIGER.security.dto.NuevoUsuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

@SpringBootTest
public class AuthControllerTest {

    @Autowired
    AuthController authController;

    @Test
    public void  registrarUsuario() {

        NuevoUsuario nuevoUsuario = NuevoUsuario.builder().username("DPVMZA").password("1234")
                .email("alexis.bahi@alumnos.frm.utn.edu.ar").build();
        BindingResult result = new BeanPropertyBindingResult(nuevoUsuario, "nuevoUsuario");
        ResponseEntity<?> response = authController.register(nuevoUsuario,result);

        Assert.isTrue(response.getStatusCode().is2xxSuccessful(),response.getBody().toString());

    }

    @Test
    public void loginUsuario() {
        //La primera ejecución puede fallar por ejecutarse antes que registrarUsuario() y no haber datos cargados

        LoginUsuario loginUsuario = new LoginUsuario("DPVMZA","1234");
        BindingResult result = new BeanPropertyBindingResult(loginUsuario, "loginUsuario");
        ResponseEntity<JwtDTO> response = authController.login(loginUsuario, result);

        Assert.isTrue(response.getStatusCode().is2xxSuccessful(),response.getBody().toString());

    }

}
