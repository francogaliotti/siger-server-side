package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.model.requests.EstadoBoletaRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

@SpringBootTest
public class EstadoBoletaTest {

    @Autowired
    EstadoBoletaController estadoBoletaController;
    EstadoBoletaRequest estadoBoletaRequest = new EstadoBoletaRequest();

    @Test
    public void cargarBoleta() throws Exception {

        this.estadoBoletaRequest.setCodEstadoBoleta("AA");
        this.estadoBoletaRequest.setNombreEstadoBoleta("Estado de boleta de prueba");

        ResponseEntity responseEntity = estadoBoletaController.post(this.estadoBoletaRequest);

        Assert.isTrue(responseEntity.getStatusCode().is2xxSuccessful(), responseEntity.toString());
    }
}
