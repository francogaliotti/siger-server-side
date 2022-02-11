package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.*;
import com.SIGER.SIGER.model.requests.LicenciaRequest;
import com.SIGER.SIGER.model.responses.LicenciaResponse;
import com.SIGER.SIGER.services.EmpleadoService;
import com.SIGER.SIGER.services.EstadoLicenciaService;
import com.SIGER.SIGER.services.LicenciaService;
import com.SIGER.SIGER.services.TipoLicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Component
public class LicenciaExpert extends AbsBaseExpert<Licencia, LicenciaService, LicenciaRequest, LicenciaResponse> {

    @Autowired
    PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

    @Autowired
    LicenciaService licenciaService;

    @Autowired
    EstadoLicenciaService estadoLicenciaService;

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    TipoLicenciaService tipoLicenciaService;

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

        if (validateSurplusDays(licenciaRequest) == true) {
            return new ResponseEntity(new Message("No tiene dias suficientes para solicitar esta licencia"), HttpStatus.BAD_REQUEST);
        }
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

    public boolean validateSurplusDays(LicenciaRequest licenciaRequest) throws Exception {
        Empleado empleado = empleadoService.findById(licenciaRequest.getEmpleado().getId());
        TipoLicencia tipoLicencia = tipoLicenciaService.findById(licenciaRequest.getTipoLicencia().getId());
        long cantidadDias = 0;
        boolean flag = false;
        for (int i = 0; i < empleado.getRemanenteDiasLicencias().size(); i++) {
            if (empleado.getRemanenteDiasLicencias().get(i).getTipoLicencia().getId() == tipoLicencia.getId()){
                cantidadDias = calculateDifferenceBetweenTwoDate(licenciaRequest.getFechaInicioLicencia(), licenciaRequest.getFechaFinLicencia());
                System.out.println("cantidad de dias: "+cantidadDias);
                System.out.println("dias sobrantes: "+empleado.getRemanenteDiasLicencias().get(i).getDiasSobrantes());

                if (cantidadDias > empleado.getRemanenteDiasLicencias().get(i).getDiasSobrantes()) {
                    System.out.println("cantidad dias: " + cantidadDias);
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }

    public long calculateDifferenceBetweenTwoDate(LocalDateTime initialDate, LocalDateTime finalDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("uuuu-MM-dd'T'HH:mm", Locale.US);
        Date firstDate = simpleDateFormat.parse(initialDate.toString());
        Date secondDate = simpleDateFormat.parse(finalDate.toString());
        long diff = secondDate.getTime() - firstDate.getTime();
        TimeUnit time = TimeUnit.DAYS;
        return time.convert(diff, TimeUnit.MILLISECONDS);
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

    public ResponseEntity<LicenciaResponse> authorize(Long id) throws Exception {
        Licencia licencia = licenciaService.findById(id);
        licencia.setFechaControl(new Date());
        for (int i = 0; i < licencia.getFechasCambioEstadoLicencia().size(); i++) {
            if (licencia.getFechasCambioEstadoLicencia().get(i).getFechaFinEstadoLicencia() == null) {
                licencia.getFechasCambioEstadoLicencia().get(i).setFechaFinEstadoLicencia(new Date());
            }
        }
        EstadoLicencia estadoLicencia = estadoLicenciaService.findById(2L);
        FechaCambioEstadoLicencia fechaAprobacion = new FechaCambioEstadoLicencia();
        fechaAprobacion.setEstadoLicencia(estadoLicencia);
        fechaAprobacion.setFechaCambioEstadoLicencia(new Date());
        licencia.getFechasCambioEstadoLicencia().add(fechaAprobacion);
        try {
            surplusDaysSubtraction(licencia);
        }catch (Exception e){
            System.out.println("El error es: "+e);
        }
        licenciaService.update(id, licencia);
        return new ResponseEntity(new Message("Licencia autorizada"), HttpStatus.OK);
    }

    public void surplusDaysSubtraction(Licencia licencia) throws Exception {
        Empleado empleado = licencia.getEmpleado();
        Long cantidadDias = null;
        for (int i = 0; i < empleado.getRemanenteDiasLicencias().size(); i++) {
            if (empleado.getRemanenteDiasLicencias().get(i).getTipoLicencia().getId() == licencia.getTipoLicencia().getId()) {
                cantidadDias = calculateDifferenceBetweenTwoDate(licencia.getFechaInicioLicencia(), licencia.getFechaFinLicencia());
                empleado.getRemanenteDiasLicencias().get(i).setDiasSobrantes(empleado.getRemanenteDiasLicencias().get(i).getDiasSobrantes() - cantidadDias.intValue());
                empleadoService.update(empleado.getId(), empleado);
            }
        }

    }

    public ResponseEntity<LicenciaResponse> reject(Long id) throws Exception {
        Licencia licencia = licenciaService.findById(id);
        licencia.setFechaControl(new Date());
        for (int i = 0; i < licencia.getFechasCambioEstadoLicencia().size(); i++) {
            if (licencia.getFechasCambioEstadoLicencia().get(i).getFechaFinEstadoLicencia() == null) {
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
