package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.DocumentoIdentidad;
import com.SIGER.SIGER.model.entities.Empleado;
import com.SIGER.SIGER.model.entities.Nacionalidad;
import com.SIGER.SIGER.model.entities.TipoDocumento;
import com.SIGER.SIGER.model.requests.EmpleadoRequest;
import com.SIGER.SIGER.model.responses.EmpleadoResponse;
import com.SIGER.SIGER.security.entity.Usuario;
import com.SIGER.SIGER.security.service.UsuarioService;
import com.SIGER.SIGER.services.EmpleadoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import org.thymeleaf.standard.processor.StandardIfTagProcessor;

@Component
public class EmpleadoExpert extends
    AbsBaseExpert<Empleado, EmpleadoService, EmpleadoRequest, EmpleadoResponse> {

  @Autowired
  EmpleadoService empleadoService;

  @Autowired
  PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

  @Autowired
  UsuarioService userService;

  @Override
  public ResponseEntity<List<EmpleadoResponse>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {

    Page<Empleado> empleadoPage = empleadoService.findAll(page, size);
    paginatedResultsHeaderUtils.addLinkHeaderOnPagedResult(uriBuilder, response, page,
        empleadoPage.getTotalPages(), "/empleado");

    List<EmpleadoResponse> empleadoResponses = converterPageToList(empleadoPage.getContent());
    return new ResponseEntity(empleadoResponses, HttpStatus.OK);
  }

  private List<EmpleadoResponse> converterPageToList(List<Empleado> empleados) {

    List<EmpleadoResponse> empleadoResponses = new ArrayList<>();
    for (int i = 0; i < empleados.size(); i++) {
      empleadoResponses.add(
          modelMapper.map(empleados.get(i), EmpleadoResponse.class));
    }
    return empleadoResponses;
  }

  @Override
  public ResponseEntity<EmpleadoResponse> findById(Long id) throws Exception {
    Empleado empleado = empleadoService.findById(id);
    EmpleadoResponse empleadoResponse = modelMapper.map(empleado, EmpleadoResponse.class);
    return new ResponseEntity(empleadoResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<EmpleadoResponse> save(EmpleadoRequest empleadoRequest) throws Exception {
    if (StringUtils.isBlank(empleadoRequest.getNombre())) {
      return new ResponseEntity(new Message("El nombre del Empleado es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (StringUtils.isBlank(empleadoRequest.getApellido())) {
      return new ResponseEntity(new Message("El apellido del Empleado es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (empleadoService.existsByLegajo(empleadoRequest.getLegajo())) {
      return new ResponseEntity(new Message("El legajo del Empleado ya existe"),
          HttpStatus.BAD_REQUEST);
    }

    if (empleadoService.existsByNroIdentificacionPersonal(
        empleadoRequest.getNroIdentificacionPersonal())) {
      return new ResponseEntity(
          new Message("El Número de Identificación personal del Empleado ya existe"),
          HttpStatus.BAD_REQUEST);
    }

    Nacionalidad nationality = new Nacionalidad();
    nationality.setId(empleadoRequest.getNacionalidad().getId());
    DocumentoIdentidad identityCard = DocumentoIdentidad.builder().nroIdentidad(empleadoRequest.getNroIdentificacionPersonal()).build();
    TipoDocumento typeOfDocument = new TipoDocumento();
    typeOfDocument.setId(empleadoRequest.getDocumentoIdentidad().getTipoDocumento().getId());
    identityCard.setTipoDocumento(typeOfDocument);

    Empleado empleado1 = Empleado.builder()
        .nombre(empleadoRequest.getNombre())
        .apellido(empleadoRequest.getApellido())
        .nroTelefonoFijo(empleadoRequest.getNroTelefonoFijo())
        .nroTelefonoCelular(empleadoRequest.getNroTelefonoCelular())
        .correoPersonal(empleadoRequest.getCorreoPersonal())
        .nacionalidad(nationality)
        .fechaNacimiento(empleadoRequest.getFechaNacimiento())
        .estadoCivil(empleadoRequest.getEstadoCivil())
        .legajo(empleadoRequest.getLegajo())
         .documentoIdentidad(identityCard)
        .build();

    empleadoService.save(empleado1);

    return new ResponseEntity(new Message("Empleado creado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<EmpleadoResponse> update(Long id, EmpleadoRequest empleadoRequest)
      throws Exception {

    if (empleadoService.findById(id).equals(false)) {
      return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
    }

    if (StringUtils.isBlank(empleadoRequest.getNombre())) {
      return new ResponseEntity(new Message("El nombre del Empleado es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }
    if (StringUtils.isBlank(empleadoRequest.getApellido())) {
      return new ResponseEntity(new Message("El apellido del Empleado es obligatorio"),
          HttpStatus.BAD_REQUEST);
    }

    Empleado empleado = new Empleado();

    empleado.setCorreoPersonal(empleadoRequest.getCorreoPersonal());
    empleado.setNroTelefonoCelular(empleado.getNroTelefonoCelular());
    empleado.setNroTelefonoFijo(empleado.getNroTelefonoFijo());
    empleado.setEstadoCivil(empleado.getEstadoCivil());
    empleado.setRompeReglaFichadaSupervisor(empleado.isRompeReglaFichadaSupervisor());
    empleado.setPuedeAprobarRequerimiento(empleado.isPuedeAprobarRequerimiento());
    empleado.setEsEncargado(empleado.isEsEncargado());

    empleadoService.update(id, empleado);

    return new ResponseEntity(new Message("Empleado actualizado"), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<?> delete(Long id) throws Exception {
    empleadoService.delete(id);
    return new ResponseEntity(new Message("Empleado eliminado"), HttpStatus.OK);
  }

  public ResponseEntity<EmpleadoResponse> getByUserName(String username) throws Exception {

    Optional<Usuario> optionalUser = userService.getByUsername(username);
    Usuario user = null;
    if(optionalUser.isPresent()) user = optionalUser.get();

    Empleado empleado = empleadoService.getByfk_usuario(user.getId());
    EmpleadoResponse empleadoResponse = modelMapper.map(empleado, EmpleadoResponse.class);
    return new ResponseEntity(empleadoResponse, HttpStatus.OK);
  }

}
