package com.SIGER.SIGER.controllers;


import com.SIGER.SIGER.entities.ZonaInhospita;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

@SpringBootTest
public class ZonaInhospitaControllerTest {
    @Autowired
    ZonaInhospitaController zonaInhospitaController;
    ZonaInhospita zonaInhospita = new ZonaInhospita();

    @Test
    public void cargarZonaInhospita(){
        this.zonaInhospita.setCodZona("009");
        this.zonaInhospita.setDenominacionZona("Perdriel");
        this.zonaInhospita.setPrecio(900);

        ResponseEntity responseEntity = zonaInhospitaController.save(zonaInhospita);

        Assert.isTrue(responseEntity.getStatusCode().is2xxSuccessful(), responseEntity.toString());
    }
    @Test
    public void editarZonaInhospita(){
        ZonaInhospita zona2 = new ZonaInhospita();
        Long id = Long.valueOf(1);
        zona2.setCodZona("002");
        zona2.setDenominacionZona("Lulunta");
        zona2.setPrecio(900);

        ResponseEntity responseEntity = zonaInhospitaController.update(id, zona2);

        Assert.isTrue(responseEntity.getStatusCode().is2xxSuccessful(), responseEntity.toString());
    }


}
