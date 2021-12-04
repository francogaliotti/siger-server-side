package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.model.requests.ViaticoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

@SpringBootTest
public class ViaticoTesting {

    @Autowired
    ViaticoController viaticoController;
    ViaticoRequest viaticoRequest = new ViaticoRequest();

    @Test
    public void cargarViatico() throws Exception {

        this.viaticoRequest.setCodViatico("AA");
        this.viaticoRequest.setDenominacionViatico("Viatico de prueba");
        this.viaticoRequest.setImporte(100);

        ResponseEntity responseEntity = viaticoController.post(this.viaticoRequest);

        Assert.isTrue(responseEntity.getStatusCode().is2xxSuccessful(), responseEntity.toString());
    }

    @Test
    public void editarViatico() throws Exception {

        Long id = Long.valueOf(1);
        this.viaticoRequest.setCodViatico("AA");
        this.viaticoRequest.setDenominacionViatico("Viatico de prueba");
        this.viaticoRequest.setImporte(200);

        ResponseEntity responseEntity = viaticoController.put(id, this.viaticoRequest);

        Assert.isTrue(responseEntity.getStatusCode().is2xxSuccessful(), responseEntity.toString());

    }

    @Test
    public void borrarViatico() throws Exception {

        Long id = Long.valueOf(1);

        ResponseEntity responseEntity = viaticoController.delete(id);

        Assert.isTrue(responseEntity.getStatusCode().is2xxSuccessful(), responseEntity.toString());

    }

    @Test
    public void cargarViaticoConCodigoErroneo() throws Exception {

        this.viaticoRequest.setCodViatico("");
        this.viaticoRequest.setDenominacionViatico("Viatico de prueba");
        this.viaticoRequest.setImporte(100);

        ResponseEntity responseEntity = viaticoController.post(this.viaticoRequest);

        Assert.isTrue(responseEntity.getStatusCode().is4xxClientError(), responseEntity.toString());
    }

    @Test
    public void cargarViaticoConDenominacionErroneo() throws Exception {

        this.viaticoRequest.setCodViatico("AA");
        this.viaticoRequest.setDenominacionViatico("");
        this.viaticoRequest.setImporte(100);

        ResponseEntity responseEntity = viaticoController.post(this.viaticoRequest);

        Assert.isTrue(responseEntity.getStatusCode().is4xxClientError(), responseEntity.toString());
    }

    @Test
    public void cargarViaticoConImporteErroneo() throws Exception {

        this.viaticoRequest.setCodViatico("AA");
        this.viaticoRequest.setDenominacionViatico("Viatico de prueba");
        this.viaticoRequest.setImporte(-100);

        ResponseEntity responseEntity = viaticoController.post(this.viaticoRequest);

        Assert.isTrue(responseEntity.getStatusCode().is4xxClientError(), responseEntity.toString());
    }
}
