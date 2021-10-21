package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.entities.Viatico;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

@SpringBootTest
public class ViaticoTesting {

    @Autowired
    ViaticoController viaticoController;
    Viatico viatico = new Viatico();

    @Test
    public void cargarViatico(){

        this.viatico.setCodViatico("AA");
        this.viatico.setDenominacionViatico("Viatico de prueba");
        this.viatico.setImporte(100);

        ResponseEntity responseEntity = viaticoController.save(this.viatico);

        Assert.isTrue(responseEntity.getStatusCode().is2xxSuccessful(), responseEntity.toString());
    }

    @Test
    public void editarViatico(){

        Long id = Long.valueOf(1);
        this.viatico.setCodViatico("AA");
        this.viatico.setDenominacionViatico("Viatico de prueba");
        this.viatico.setImporte(200);

        ResponseEntity responseEntity = viaticoController.update(id, this.viatico);

        Assert.isTrue(responseEntity.getStatusCode().is2xxSuccessful(), responseEntity.toString());

    }

    @Test
    public void borrarViatico(){

        Long id = Long.valueOf(1);

        ResponseEntity responseEntity = viaticoController.delete(id);

        Assert.isTrue(responseEntity.getStatusCode().is2xxSuccessful(), responseEntity.toString());

    }

    @Test
    public void cargarViaticoConCodigoErroneo(){

        this.viatico.setCodViatico("");
        this.viatico.setDenominacionViatico("Viatico de prueba");
        this.viatico.setImporte(100);

        ResponseEntity responseEntity = viaticoController.save(this.viatico);

        Assert.isTrue(responseEntity.getStatusCode().is4xxClientError(), responseEntity.toString());
    }

    @Test
    public void cargarViaticoConDenominacionErroneo(){

        this.viatico.setCodViatico("AA");
        this.viatico.setDenominacionViatico("");
        this.viatico.setImporte(100);

        ResponseEntity responseEntity = viaticoController.save(this.viatico);

        Assert.isTrue(responseEntity.getStatusCode().is4xxClientError(), responseEntity.toString());
    }

    @Test
    public void cargarViaticoConImporteErroneo(){

        this.viatico.setCodViatico("AA");
        this.viatico.setDenominacionViatico("Viatico de prueba");
        this.viatico.setImporte(-100);

        ResponseEntity responseEntity = viaticoController.save(this.viatico);

        Assert.isTrue(responseEntity.getStatusCode().is4xxClientError(), responseEntity.toString());
    }
}
