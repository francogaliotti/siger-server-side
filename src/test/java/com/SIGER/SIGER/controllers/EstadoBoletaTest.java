package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.entities.EstadoBoleta;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

@SpringBootTest
public class EstadoBoletaTest {

    @Autowired
    EstadoBoletaController estadoBoletaController;
    EstadoBoleta estadoBoleta = new EstadoBoleta();

    @Test
    public void cargarBoleta(){

        this.estadoBoleta.setCodEstadoBoleta("AA");
        this.estadoBoleta.setNombreEstadoBoleta("Estado de boleta de prueba");

        ResponseEntity responseEntity = estadoBoletaController.save(this.estadoBoleta);

        Assert.isTrue(responseEntity.getStatusCode().is2xxSuccessful(), responseEntity.toString());
    }
}
