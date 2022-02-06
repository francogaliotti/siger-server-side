package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.Asistencia;
import com.SIGER.SIGER.model.entities.Empleado;
import com.SIGER.SIGER.model.requests.AsistenciaRequest;
import com.SIGER.SIGER.model.responses.AsistenciaResponse;
import com.SIGER.SIGER.repositories.AsistenciaRepository;
import com.SIGER.SIGER.repositories.EmpleadoRepository;
import com.SIGER.SIGER.services.AsistenciaService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class AsistenciaExpert extends
    AbsBaseExpert<Asistencia, AsistenciaService, AsistenciaRequest, AsistenciaResponse> {

  @Autowired
  AsistenciaService asistenciaService;

  @Autowired
  EmpleadoRepository empleadoRepository;

  @Autowired
  AsistenciaRepository asistenciaRepository;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<AsistenciaResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<Asistencia> asistenciaPage = asistenciaService.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        asistenciaPage.getTotalPages(), "/asistencia");
    List<AsistenciaResponse> asistenciaResponses = converterPageToList(
        asistenciaPage.getContent());
    return new ResponseEntity(asistenciaResponses, HttpStatus.OK);
  }

  private List<AsistenciaResponse> converterPageToList(List<Asistencia> asistencias) {

    List<AsistenciaResponse> asistenciaResponses = new ArrayList<>();
    for (int i = 0; i < asistencias.size(); i++) {
      asistenciaResponses.add(covertAsistenciToAsistenciaResponse(asistencias.get(i)));
      /*asistenciaResponses.add(
          modelMapper.map(asistencias.get(i), AsistenciaResponse.class));*/
    }
    return asistenciaResponses;
  }

  public AsistenciaResponse covertAsistenciToAsistenciaResponse(Asistencia asistencia){

    //LocalDateTime date = LocalDateTime.now();
    //DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss z uuuu", Locale.US);
    DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm", Locale.US);
    LocalDateTime fechaHora = LocalDateTime.parse(asistencia.getFechaHora(),formatter);

    AsistenciaResponse asistenciaResponse = new AsistenciaResponse();
    asistenciaResponse.setId(asistencia.getId());
    asistenciaResponse.setFechaAlta(asistencia.getFechaAlta());
    asistenciaResponse.setFechaBaja(asistencia.getFechaBaja());
    asistenciaResponse.setFechaHora(fechaHora);
    asistenciaResponse.setFechaCierre(asistencia.getFechaCierre());
    asistenciaResponse.setFechaModificacion(asistencia.getFechaModificacion());
    asistenciaResponse.setFechaSincronizacion(asistencia.getFechaSincronizacion());
    asistenciaResponse.setReloj(asistencia.getReloj());
    asistenciaResponse.setSupervisor(asistencia.isSupervisor());
    asistenciaResponse.setTipoMovimiento(asistencia.getTipoMovimiento());
    asistenciaResponse.setExcesoHorario(asistencia.getExcesoHorario());
    asistenciaResponse.setHoraAsignado(asistencia.getHoraAsignado());
    asistenciaResponse.setMinutoAsignado(asistencia.getMinutoAsignado());
    asistenciaResponse.setViaticoGabinete(asistencia.isViaticoGabinete());
    asistenciaResponse.setEmpleado(asistencia.getEmpleado());
    return asistenciaResponse;
  }

  public ResponseEntity<List<AsistenciaResponse>> findAllMyAttendances(long id, int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<Asistencia> asistenciaPage = asistenciaService.findByEmpleado(id,page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        asistenciaPage.getTotalPages(), "/mis-asistencias");
    List<AsistenciaResponse> asistenciaResponses = converterMyAttendancePageToList(
        asistenciaPage.getContent());
    return new ResponseEntity(asistenciaResponses, HttpStatus.OK);
  }

  private List<AsistenciaResponse> converterMyAttendancePageToList(List<Asistencia> asistencias) {

    List<AsistenciaResponse> asistenciaResponses = new ArrayList<>();
    for (int i = 0; i < asistencias.size(); i++) {
      asistenciaResponses.add(covertAsistenciToAsistenciaResponse(asistencias.get(i)));
      /*asistenciaResponses.add(
          modelMapper.map(asistencias.get(i), AsistenciaResponse.class));*/
    }
    return asistenciaResponses;
  }

  @Override
  public ResponseEntity<AsistenciaResponse> findById(Long id) throws Exception {
    Asistencia asistencia = asistenciaService.findById(id);
    AsistenciaResponse asistenciaResponse = covertAsistenciToAsistenciaResponse(asistencia);
    /*AsistenciaResponse asistenciaResponse = modelMapper.map(asistencia,
        AsistenciaResponse.class);*/
    return new ResponseEntity(asistenciaResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<AsistenciaResponse> save(AsistenciaRequest asistenciaRequest)
      throws Exception {
    /*
    if (asistenciaRequest.getFechaHora().equals(null)) {
      return new ResponseEntity(new Message("La fecha es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }
*/
    Asistencia asistencia = Asistencia.builder()
        .fechaAlta(new Date())
        .fechaHora(asistenciaRequest.getFechaHora().toString())
        .reloj("0")
        .supervisor(true)
        .tipoMovimiento(asistenciaRequest.getTipoMovimiento().charAt(0))
        .empleado(asistenciaRequest.getEmpleado())
        .build();

    asistenciaService.save(asistencia);

    return new ResponseEntity(new Message("Asistencia creada"), HttpStatus.OK);
  }

  public ResponseEntity<AsistenciaResponse> automaticLoad()
      throws CsvValidationException, IOException {

    File path = new File("assets/attendance/asistencia.csv");

    CSVReader csvReader = new CSVReader(new FileReader(path.getAbsolutePath()));

    List<Asistencia> asistencias = new ArrayList<>();

    String[] columna;

    while ((columna = csvReader.readNext()) != null) {
      Optional<Empleado> empleadoOptional = empleadoRepository.findByLegajo(columna[0]);
      if (empleadoOptional.isPresent()) {
        asistencias.add(Asistencia.builder()
            .fechaAlta(new Date())
            .fechaHora(columna[1])
            .tipoMovimiento(columna[2].charAt(0))
            .reloj(columna[3])
            .supervisor(false)
            .empleado(empleadoOptional.get())
            .build());
      }
    }
    Iterable<Asistencia> asistenciaIterable = asistencias;
    asistenciaRepository.saveAll(asistenciaIterable);
    csvReader.close();
    return new ResponseEntity(new Message("Carga automática exitosa"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<AsistenciaResponse> update(Long id,
      AsistenciaRequest asistenciaRequest) throws Exception {

    if (asistenciaService.findById(id).equals(false)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }

    /*if (asistenciaRequest.getFechaHora().equals(null)) {
      return new ResponseEntity(new Message("La fecha es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }*/

    Asistencia asistencia = Asistencia.builder()
        .fechaAlta(new Date())
        .fechaHora(asistenciaRequest.getFechaHora().toString())
        .reloj("0")
        .supervisor(true)
        .tipoMovimiento(asistenciaRequest.getTipoMovimiento().charAt(0))
        .empleado(asistenciaRequest.getEmpleado())
        .fechaModificacion(new Date())
        .build();

    asistenciaService.update(id, asistencia);

    return new ResponseEntity(new Message("Asistencia actualizada"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    Asistencia asistencia = asistenciaService.findById(id);
    asistencia.setFechaBaja(new Date());
    asistenciaService.update(id, asistencia);
    asistenciaService.delete(id);
    return new ResponseEntity(new Message("Asistencia eliminada"), HttpStatus.NO_CONTENT);
  }

}
