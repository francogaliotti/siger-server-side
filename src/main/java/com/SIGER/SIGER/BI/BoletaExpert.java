package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.*;
import com.SIGER.SIGER.model.requests.BoletaRequest;
import com.SIGER.SIGER.model.requests.LicenciaRequest;
import com.SIGER.SIGER.model.responses.BoletaResponse;
import com.SIGER.SIGER.model.responses.LicenciaResponse;
import com.SIGER.SIGER.services.BoletaService;
import com.SIGER.SIGER.services.EstadoBoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BoletaExpert extends
    AbsBaseExpert<Boleta, BoletaService, BoletaRequest, BoletaResponse> {

    @Autowired
    PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

    @Autowired
    BoletaService boletaService;

    @Autowired
    EstadoBoletaService estadoBoletaService;

    private List<BoletaResponse> converterPageToList(List<Boleta> boletas) {

        List<BoletaResponse> boletaResponses = new ArrayList<>();
        for (int i = 0; i < boletas.size(); i++) {
            boletaResponses.add(
                    modelMapper.map(boletas.get(i), BoletaResponse.class));
        }
        return boletaResponses;
    }

    @Override
    public ResponseEntity<BoletaResponse> findById(Long id) throws Exception {
        Boleta boleta = boletaService.findById(id);
        BoletaResponse boletaResponse = modelMapper.map(boleta,
                BoletaResponse.class);
        return new ResponseEntity(boletaResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BoletaResponse>> findAll(int page, int size,
                                                          UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

        Page<Boleta> boletaPage = boletaService.findAll(page, size);
        paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
                boletaPage.getTotalPages(), "/boleta");

        List<BoletaResponse> boletaResponses = converterPageToList(
                boletaPage.getContent());
        return new ResponseEntity(boletaResponses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BoletaResponse> save(BoletaRequest boletaRequest)
            throws Exception {


        Boleta boleta = modelMapper.map(boletaRequest, Boleta.class);
        EstadoBoleta estadoBoleta = estadoBoletaService.findById(1L);
        FechaCambioEstadoBoleta fechaCreacion = new FechaCambioEstadoBoleta();
        fechaCreacion.setEstadoBoleta(estadoBoleta);
        fechaCreacion.setFechaCambioEstadoBoleta(new Date());
        boleta.getFechasCambioEstadoBoleta().add(fechaCreacion);
        boleta.setFechaAlta(new Date());

        boletaService.save(boleta);

        return new ResponseEntity(new Message("Boleta creada"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BoletaResponse> update(Long id,
                                                   BoletaRequest boletaRequest)
            throws Exception {




        Boleta boleta = boletaService.findById(id);

        boleta.setTipoBoleta(boletaRequest.getTipoBoleta());
        boleta.setObservacionesBoleta(boletaRequest.getObservacionesBoleta());
        boleta.setFechaHoraPosibleLlegada(boletaRequest.getFechaHoraPosibleLlegada());
        boleta.setFechaHoraPosibleSalida(boletaRequest.getFechaHoraPosibleSalida());
        boleta.setFechaCierre(boletaRequest.getFechaCierre());
        boleta.setFechaControl(boletaRequest.getFechaControl());



        boletaService.update(id, boleta);

        return new ResponseEntity(new Message("Boleta actualizada"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Long id) throws Exception {
        boletaService.delete(id);
        return new ResponseEntity(new Message("Boleta eliminada"), HttpStatus.OK);
    }

}
