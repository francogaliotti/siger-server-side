package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.RegimenHorario;
import com.SIGER.SIGER.model.requests.RegimenHorarioRequest;
import com.SIGER.SIGER.model.responses.RegimenHorarioResponse;
import com.SIGER.SIGER.services.RegimenHorarioService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RegimenHorarioExpert extends
    AbsBaseExpert<RegimenHorario, RegimenHorarioService, RegimenHorarioRequest, RegimenHorarioResponse> {

  @Autowired
  RegimenHorarioService regimenHorarioService;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Override
  public ResponseEntity<List<RegimenHorarioResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<RegimenHorario> regimenHorarioPage = regimenHorarioService.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        regimenHorarioPage.getTotalPages(), "/regimen-horario");
    List<RegimenHorarioResponse> regimenHorarioResponses = converterPageToList(
        regimenHorarioPage.getContent());
    return new ResponseEntity(regimenHorarioResponses, HttpStatus.OK);
  }

  private List<RegimenHorarioResponse> converterPageToList(List<RegimenHorario> regimenHorarios) {

    List<RegimenHorarioResponse> regimenHorarioResponses = new ArrayList<>();
    for (int i = 0; i < regimenHorarios.size(); i++) {
      regimenHorarioResponses.add(
          modelMapper.map(regimenHorarios.get(i), RegimenHorarioResponse.class));
    }
    return regimenHorarioResponses;
  }

  @Override
  public ResponseEntity<RegimenHorarioResponse> findById(Long id) throws Exception {
    RegimenHorario regimenHorario = regimenHorarioService.findById(id);
    RegimenHorarioResponse regimenHorarioResponse = modelMapper.map(regimenHorario,
        RegimenHorarioResponse.class);
    return new ResponseEntity(regimenHorarioResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<RegimenHorarioResponse> save(RegimenHorarioRequest regimenHorarioRequest)
      throws Exception {

    if (regimenHorarioRequest.getHoraMinutoInicioJornadaLaboral() == null) {
      return new ResponseEntity(new Message("La hora de inicio es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }
    if (regimenHorarioRequest.getHoraMinutoFinJornadaLaboral() == null) {
      return new ResponseEntity(new Message("La hora de fin es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }

    RegimenHorario regimenHorario = RegimenHorario.builder()
        .fechaInicioVigenciaRegimenHorario(new Date())
        .horaMinutoInicioJornadaLaboral(regimenHorarioRequest.getHoraMinutoInicioJornadaLaboral())
        .horaMinutoFinJornadaLaboral(regimenHorarioRequest.getHoraMinutoFinJornadaLaboral())
        .tipoRegimenHorario(regimenHorarioRequest.getTipoRegimenHorario()).build();

    regimenHorarioService.save(regimenHorario);

    return new ResponseEntity(new Message("Regimen Horario creado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<RegimenHorarioResponse> update(Long id,
      RegimenHorarioRequest regimenHorarioRequest) throws Exception {

    if (regimenHorarioService.findById(id).equals(false)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }

    if (regimenHorarioRequest.getHoraMinutoInicioJornadaLaboral() == null) {
      return new ResponseEntity(new Message("La hora de inicio es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }
    if (regimenHorarioRequest.getHoraMinutoFinJornadaLaboral() == null) {
      return new ResponseEntity(new Message("La hora de fin es obligatoria"),
          HttpStatus.BAD_REQUEST);
    }

    RegimenHorario regimenHorario = RegimenHorario.builder()
        .horaMinutoInicioJornadaLaboral(regimenHorarioRequest.getHoraMinutoInicioJornadaLaboral())
        .horaMinutoFinJornadaLaboral(regimenHorarioRequest.getHoraMinutoFinJornadaLaboral())
        .tipoRegimenHorario(regimenHorarioRequest.getTipoRegimenHorario()).build();
    regimenHorarioService.update(id, regimenHorario);

    return new ResponseEntity(new Message("Regimen Horario actualizado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    RegimenHorario regimenHorario = regimenHorarioService.findById(id);
    regimenHorario.setFechaFinVigenciaRegimenHorario(new Date());
    regimenHorarioService.update(id, regimenHorario);
    regimenHorarioService.delete(id);
    return new ResponseEntity(new Message("Regimen Horario eliminado"), HttpStatus.NO_CONTENT);
  }

}
