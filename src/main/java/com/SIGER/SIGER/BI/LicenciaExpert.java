package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.*;
import com.SIGER.SIGER.model.requests.LicenciaRequest;
import com.SIGER.SIGER.model.responses.BoletaResponse;
import com.SIGER.SIGER.model.responses.LicenciaResponse;
import com.SIGER.SIGER.services.EstadoLicenciaService;
import com.SIGER.SIGER.services.LicenciaService;
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
public class LicenciaExpert extends AbsBaseExpert<Licencia, LicenciaService, LicenciaRequest, LicenciaResponse>{

    @Autowired
    PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

    @Autowired
    LicenciaService licenciaService;

    @Autowired
    EstadoLicenciaService estadoLicenciaService;

    private List<LicenciaResponse> converterPageToList(List<Licencia> licencias) {

        List<LicenciaResponse> licenciaResponses = new ArrayList<>();
        for (int i = 0; i < licencias.size(); i++) {
            licenciaResponses.add(
                    modelMapper.map(licencias.get(i), LicenciaResponse.class));
        }
        return licenciaResponses;
    }

    @Override
    public ResponseEntity<LicenciaResponse> findById(Long id) throws Exception {
        Licencia licencia = licenciaService.findById(id);
        LicenciaResponse licenciaResponse = modelMapper.map(licencia,
                LicenciaResponse.class);
        return new ResponseEntity(licenciaResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LicenciaResponse>> findAll(int page, int size,
                                                              UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

        Page<Licencia> licenciaPage = licenciaService.findAll(page, size);
        paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
                licenciaPage.getTotalPages(), "/licencia");

        List<LicenciaResponse> licenciaResponses = converterPageToList(
                licenciaPage.getContent());
        return new ResponseEntity(licenciaResponses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<LicenciaResponse> save(LicenciaRequest licenciaRequest)
            throws Exception {


        Licencia licencia = modelMapper.map(licenciaRequest, Licencia.class);
        EstadoLicencia estadoLicencia = estadoLicenciaService.findById(1L);
        FechaCambioEstadoLicencia fechaCreacion = new FechaCambioEstadoLicencia();
        fechaCreacion.setEstadoLicencia(estadoLicencia);
        fechaCreacion.setFechaCambioEstadoLicencia(new Date());
        licencia.getFechasCambioEstadoLicencia().add(fechaCreacion);
        licencia.setFechaAlta(new Date());

        licenciaService.save(licencia);

        return new ResponseEntity(new Message("Licencia creada"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<LicenciaResponse> update(Long id,
                                                       LicenciaRequest licenciaRequest)
            throws Exception {




        Licencia licencia = licenciaService.findById(id);

        licencia.setTipoLicencia(licenciaRequest.getTipoLicencia());
        licencia.setObservacionesLicencia(licenciaRequest.getObservacionesLicencia());
        licencia.setFechaInicioLicencia(licenciaRequest.getFechaInicioLicencia());
        licencia.setFechaFinLicencia(licenciaRequest.getFechaFinLicencia());
        licencia.setFechaFrancoCompensatorio(licenciaRequest.getFechaFrancoCompensatorio());
        licencia.setFechaCierre(licenciaRequest.getFechaCierre());
        licencia.setFechaControl(licenciaRequest.getFechaControl());



        licenciaService.update(id, licencia);

        return new ResponseEntity(new Message("Licencia actualizada"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Long id) throws Exception {
        Licencia licencia = licenciaService.findById(id);
        licencia.setFechaBaja(new Date());
        licenciaService.update(id, licencia);
        licenciaService.delete(id);
        return new ResponseEntity(new Message("Licencia eliminada"), HttpStatus.OK);
    }
    public ResponseEntity<LicenciaResponse> authorize(Long id) throws Exception{
        Licencia licencia = licenciaService.findById(id);
        licencia.setFechaControl(new Date());
        for (int i = 0; i<licencia.getFechasCambioEstadoLicencia().size(); i++){
            if (licencia.getFechasCambioEstadoLicencia().get(i).getFechaFinEstadoLicencia()==null){
                licencia.getFechasCambioEstadoLicencia().get(i).setFechaFinEstadoLicencia(new Date());
            }
        }
        EstadoLicencia estadoLicencia = estadoLicenciaService.findById(2L);
        FechaCambioEstadoLicencia fechaAprobacion = new FechaCambioEstadoLicencia();
        fechaAprobacion.setEstadoLicencia(estadoLicencia);
        fechaAprobacion.setFechaCambioEstadoLicencia(new Date());
        licencia.getFechasCambioEstadoLicencia().add(fechaAprobacion);
        licenciaService.update(id, licencia);
        return new ResponseEntity(new Message("Licencia autorizada"), HttpStatus.OK);
    }

    public ResponseEntity<LicenciaResponse> reject(Long id) throws Exception{
        Licencia licencia = licenciaService.findById(id);
        licencia.setFechaControl(new Date());
        for (int i = 0; i<licencia.getFechasCambioEstadoLicencia().size(); i++){
            if (licencia.getFechasCambioEstadoLicencia().get(i).getFechaFinEstadoLicencia()==null){
                licencia.getFechasCambioEstadoLicencia().get(i).setFechaFinEstadoLicencia(new Date());
            }
        }
        EstadoLicencia estadoLicencia = estadoLicenciaService.findById(3L);
        FechaCambioEstadoLicencia fechaRechazo = new FechaCambioEstadoLicencia();
        fechaRechazo.setEstadoLicencia(estadoLicencia);
        fechaRechazo.setFechaCambioEstadoLicencia(new Date());
        licencia.getFechasCambioEstadoLicencia().add(fechaRechazo);
        licenciaService.update(id, licencia);
        return new ResponseEntity(new Message("Licencia rechazada"), HttpStatus.OK);
    }
}