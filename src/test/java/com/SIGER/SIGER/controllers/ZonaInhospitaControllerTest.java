package com.SIGER.SIGER.controllers;


import com.SIGER.SIGER.model.requests.ZonaInhospitaRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

@SpringBootTest
public class ZonaInhospitaControllerTest {
    @Autowired
    ZonaInhospitaController zonaInhospitaController;
    ZonaInhospitaRequest zonaInhospitaRequest = new ZonaInhospitaRequest();

    @Test
    public void cargarZonaInhospita() throws Exception {
        this.zonaInhospitaRequest.setCodZona("009");
        this.zonaInhospitaRequest.setDenominacionZona("Perdriel");
        this.zonaInhospitaRequest.setPrecio(900);

        ResponseEntity responseEntity = zonaInhospitaController.post(zonaInhospitaRequest);

        Assert.isTrue(responseEntity.getStatusCode().is2xxSuccessful(), responseEntity.toString());
    }
    @Test
    public void editarZonaInhospita() throws Exception {
        ZonaInhospitaRequest zonaInhospitaRequest = new ZonaInhospitaRequest();
        Long id = Long.valueOf(1);
        zonaInhospitaRequest.setCodZona("002");
        zonaInhospitaRequest.setDenominacionZona("Lulunta");
        zonaInhospitaRequest.setPrecio(900);

        ResponseEntity responseEntity = zonaInhospitaController.put(id, zonaInhospitaRequest);

        Assert.isTrue(responseEntity.getStatusCode().is2xxSuccessful(), responseEntity.toString());
    }


}
