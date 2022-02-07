package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.common.Message;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.datos_gob_ar.entities.Departamento;
import com.SIGER.SIGER.datos_gob_ar.entities.Localidad;
import com.SIGER.SIGER.datos_gob_ar.entities.Municipio;
import com.SIGER.SIGER.datos_gob_ar.entities.Provincia;
import com.SIGER.SIGER.emailSender.controller.EmailController;
import com.SIGER.SIGER.emailSender.dto.EmailValuesDTO;
import com.SIGER.SIGER.model.entities.DocumentoIdentidad;
import com.SIGER.SIGER.model.entities.Domicilio;
import com.SIGER.SIGER.model.entities.Empleado;
import com.SIGER.SIGER.model.entities.HistorialSectorEmpleado;
import com.SIGER.SIGER.model.entities.Nacionalidad;
import com.SIGER.SIGER.model.entities.RegimenHorario;
import com.SIGER.SIGER.model.entities.Remuneracion;
import com.SIGER.SIGER.model.entities.Sector;
import com.SIGER.SIGER.model.entities.TipoDocumento;
import com.SIGER.SIGER.model.requests.EmpleadoRequest;
import com.SIGER.SIGER.model.responses.EmpleadoResponse;
import com.SIGER.SIGER.security.entity.Rol;
import com.SIGER.SIGER.security.entity.Usuario;
import com.SIGER.SIGER.security.expert.AuthExpert;
import com.SIGER.SIGER.security.service.UsuarioService;
import com.SIGER.SIGER.services.EmpleadoService;

import java.util.*;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class EmpleadoExpert extends
        AbsBaseExpert<Empleado, EmpleadoService, EmpleadoRequest, EmpleadoResponse> {

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    PaginatedResultsHeaderUtils paginatedResultsHeaderUtils;

    @Autowired
    UsuarioService userService;

    @Autowired
    AuthExpert authExpert;

    @Autowired
    EmailController emailController;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${lowerCasesAmount}")
    int lowerCasesAmount;

    @Value("${capitalLettersAmount}")
    int capitalLettersAmount;

    @Value("${digitsAmount}")
    int digitsAmount;

    @Value("${nonAlphanumericsAmount}")
    int nonAlphanumericsAmount;


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


    public ResponseEntity<EmpleadoResponse> findByUsuarioId(Long id) throws Exception {
        Empleado empleado = empleadoService.getByfk_usuario(id);
        EmpleadoResponse empleadoResponse = modelMapper.map(empleado, EmpleadoResponse.class);
        return new ResponseEntity(empleadoResponse, HttpStatus.OK);
    }

    public ResponseEntity<Long> findEmployeeIdByUsuarioId(Long id) throws Exception {
        Empleado empleado = empleadoService.getByfk_usuario(id);
        EmpleadoResponse empleadoResponse = modelMapper.map(empleado, EmpleadoResponse.class);
        return new ResponseEntity(empleadoResponse.getId(), HttpStatus.OK);
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

        Nacionalidad nationality = new Nacionalidad();
        nationality.setId(empleadoRequest.getNacionalidad().getId());

    /*DocumentoIdentidad identityCard = DocumentoIdentidad.builder()
        .nroIdentidad(empleadoRequest.getDocumentoIdentidad().getNroIdentidad())
            .tipoDocumento(empleadoRequest.getDocumentoIdentidad().getTipoDocumento()).build();

    TipoDocumento typeOfDocument = new TipoDocumento();
    typeOfDocument.setId(empleadoRequest.getDocumentoIdentidad().getTipoDocumento().getId());
    identityCard.setTipoDocumento(typeOfDocument);*/


        Remuneracion remuneracion = Remuneracion.builder()
                .valorHora(empleadoRequest.getRemuneracion().getValorHora())
                .valorViaticoDia(empleadoRequest.getRemuneracion().getValorViaticoDia())
                .importeHorasAdicionales(empleadoRequest.getRemuneracion().getImporteHorasAdicionales())
                .importeZonaDesarraigo(empleadoRequest.getRemuneracion().getImporteZonaDesarraigo())
                .build();


        RegimenHorario regimenHorario = RegimenHorario.builder()
                .isActive(empleadoRequest.getRegimenHorario().isActive())
                .horaMinutoInicioJornadaLaboral(empleadoRequest.getRegimenHorario().getHoraMinutoInicioJornadaLaboral())
                .horaMinutoFinJornadaLaboral(empleadoRequest.getRegimenHorario().getHoraMinutoFinJornadaLaboral())
                .tipoRegimenHorario(empleadoRequest.getRegimenHorario().getTipoRegimenHorario())
                .build();
/*
    Provincia provincia = Provincia.builder()
        .categoria(empleadoRequest.getDomicilio().getProvincia().getCategoria())
        .latitud(empleadoRequest.getDomicilio().getProvincia().getLatitud())
        .longitud(empleadoRequest.getDomicilio().getProvincia().getLongitud())
        .fuente(empleadoRequest.getDomicilio().getProvincia().getFuente())
        .id(empleadoRequest.getDomicilio().getProvincia().getId())
        .iso_id(empleadoRequest.getDomicilio().getProvincia().getIso_id())
        .iso_nombre(empleadoRequest.getDomicilio().getProvincia().getIso_nombre())
        .nombre(empleadoRequest.getDomicilio().getProvincia().getNombre())
        .nombre_completo(empleadoRequest.getDomicilio().getProvincia().getNombre_completo())
        .build();

    Departamento departamento = Departamento.builder()
        .categoria(empleadoRequest.getDomicilio().getDepartamento().getCategoria())
        .latitud(empleadoRequest.getDomicilio().getDepartamento().getLatitud())
        .longitud(empleadoRequest.getDomicilio().getDepartamento().getLongitud())
        .fuente(empleadoRequest.getDomicilio().getDepartamento().getFuente())
        .id(empleadoRequest.getDomicilio().getDepartamento().getId())
        .nombre(empleadoRequest.getDomicilio().getDepartamento().getNombre())
        .nombre_completo(empleadoRequest.getDomicilio().getDepartamento().getNombre_completo())
        .provincia(empleadoRequest.getDomicilio().getDepartamento().getProvincia())
        .provinciaInterseccion(
            empleadoRequest.getDomicilio().getDepartamento().getProvinciaInterseccion())
        .provinciaNombre(empleadoRequest.getDomicilio().getDepartamento().getProvinciaNombre())
        .build();

    /*Municipio municipio = Municipio.builder()
        .categoria(empleadoRequest.getDomicilio().getMunicipio().getCategoria())
        .latitud(empleadoRequest.getDomicilio().getMunicipio().getLatitud())
        .longitud(empleadoRequest.getDomicilio().getMunicipio().getLongitud())
        .fuente(empleadoRequest.getDomicilio().getMunicipio().getFuente())
        .id(empleadoRequest.getDomicilio().getMunicipio().getFuente())
        .nombre(empleadoRequest.getDomicilio().getMunicipio().getNombre())
        .nombre_completo(empleadoRequest.getDomicilio().getMunicipio().getNombre_completo())
        .provincia(empleadoRequest.getDomicilio().getMunicipio().getProvincia())
        .provinciaInterseccion(
            empleadoRequest.getDomicilio().getMunicipio().getProvinciaInterseccion())
        .provinciaNombre(empleadoRequest.getDomicilio().getMunicipio().getProvinciaNombre())
        .build();*/ /*

    Localidad localidad = Localidad.builder()
        .categoria(empleadoRequest.getDomicilio().getLocalidad().getCategoria())
        .latitud(empleadoRequest.getDomicilio().getLocalidad().getLatitud())
        .longitud(empleadoRequest.getDomicilio().getLocalidad().getLongitud())
        .departamento(empleadoRequest.getDomicilio().getLocalidad().getDepartamento())
        .departamentoNombre(empleadoRequest.getDomicilio().getLocalidad().getDepartamentoNombre())
        .fuente(empleadoRequest.getDomicilio().getLocalidad().getFuente())
        .id(empleadoRequest.getDomicilio().getLocalidad().getId())
        .localidadCensalId(empleadoRequest.getDomicilio().getLocalidad().getLocalidadCensalId())
        .localidadCensalNombre(
            empleadoRequest.getDomicilio().getLocalidad().getLocalidadCensalNombre())
        /*.municipio(empleadoRequest.getDomicilio().getLocalidad().getMunicipio())*/ /*
        .municipioNombre(empleadoRequest.getDomicilio().getLocalidad().getMunicipioNombre())
        .nombre(empleadoRequest.getDomicilio().getLocalidad().getNombre())
        .provincia(empleadoRequest.getDomicilio().getLocalidad().getProvincia())
        .provinciaNombre(empleadoRequest.getDomicilio().getLocalidad().getProvinciaNombre())
        .build();

    */
        Set<Rol> roles = new HashSet<>();
        roles.addAll(empleadoRequest.getUsuario().getRoles());

        Usuario usuario = Usuario.builder()
                .nombre(empleadoRequest.getUsuario().getNombre())
                .username(empleadoRequest.getUsuario().getUsername())
                .correoInstitucional(empleadoRequest.getUsuario().getCorreoInstitucional())
                .password(empleadoRequest.getUsuario().getPassword())
                .image("assets/images/default_generic_profile_picture.png")
                .isFirstSignin(true)
                .enabled(empleadoRequest.getUsuario().isEnabled())
                .requiereAutorizacion(empleadoRequest.getUsuario().isRequiereAutorizacion())
                .recordarme(empleadoRequest.getUsuario().isRecordarme())
                .roles(roles).build();
/*
    Domicilio domicilio = Domicilio.builder()
        .calle(empleadoRequest.getDomicilio().getCalle())
        .nroCalle(empleadoRequest.getDomicilio().getNroCalle())
        .nroDepartamento(empleadoRequest.getDomicilio().getNroDepartamento())
        .nroPiso(empleadoRequest.getDomicilio().getNroPiso())
        .provincia(provincia)
        .departamento(departamento)
        /*.municipio(municipio)*/ /*
        .localidad(localidad).build();

    List<HistorialSectorEmpleado> historialSectorEmpleadoList = new ArrayList<>();

    for (int i = 0; i < empleadoRequest.getHistorialSectorEmpleado().size(); i++) {

      Sector sector = Sector.builder()
          .codigo(empleadoRequest.getHistorialSectorEmpleado().get(i).getSector().getCodigo())
          .denominacion(empleadoRequest.getHistorialSectorEmpleado().get(i).getSector().getDenominacion())
          .fechaBaja(empleadoRequest.getHistorialSectorEmpleado().get(i).getSector().getFechaBaja())
          .validaFueraDeHorario(empleadoRequest.getHistorialSectorEmpleado().get(i).getSector().isValidaFueraDeHorario())
          .detenerCargaBoletas(empleadoRequest.getHistorialSectorEmpleado().get(i).getSector().isDetenerCargaBoletas())
          .permiteTrabajarHorasExtras(empleadoRequest.getHistorialSectorEmpleado().get(i).getSector().isPermiteTrabajarHorasExtras())
          .maximoSerenoDiurno(empleadoRequest.getHistorialSectorEmpleado().get(i).getSector().getMaximoSerenoDiurno())
          .maximoSerenoNocturno(empleadoRequest.getHistorialSectorEmpleado().get(i).getSector().getMaximoSerenoNocturno())
          .sectorSuperior(empleadoRequest.getHistorialSectorEmpleado().get(i).getSector().getSectorSuperior())
          .tipoSector(empleadoRequest.getHistorialSectorEmpleado().get(i).getSector().getTipoSector())
          .build();
      HistorialSectorEmpleado historialSectorEmpleado = HistorialSectorEmpleado.builder()
          .fechaIngreso(new Date())
          .vigente(true)
          .sector(sector)
          .build();
      historialSectorEmpleadoList.add(historialSectorEmpleado);
    }*/

        Empleado empleado1 = Empleado.builder()
                .fechaAlta(new Date())
                .fechaBaja(null)
                .nombre(empleadoRequest.getNombre())
                .apellido(empleadoRequest.getApellido())
                .correoPersonal(empleadoRequest.getCorreoPersonal())
                .estadoCivil(empleadoRequest.getEstadoCivil())
                .legajo(empleadoRequest.getLegajo())
                .fechaLimiteReemplazo(empleadoRequest.getFechaLimiteReemplazo())
                .fechaNacimiento(empleadoRequest.getFechaNacimiento())
                .fechaIngreso(empleadoRequest.getFechaIngreso())
                .rompeReglaComisionDia(empleadoRequest.isRompeReglaComisionDia())
                .rompeReglaFichadaReloj(empleadoRequest.isRompeReglaFichadaReloj())
                .puedeAprobarRequerimiento(empleadoRequest.isPuedeAprobarRequerimiento())
                .rompeReglaFichadaSupervisor(empleadoRequest.isRompeReglaFichadaSupervisor())
                .esEncargado(empleadoRequest.isEsEncargado())
                .nroTelefonoFijo(empleadoRequest.getNroTelefonoFijo())
                .nroTelefonoCelular(empleadoRequest.getNroTelefonoCelular())
                .nacionalidad(empleadoRequest.getNacionalidad())
                .remuneracion(empleadoRequest.getRemuneracion())
                .regimenHorario(empleadoRequest.getRegimenHorario())
                .usuario(usuario)
                .domicilio(empleadoRequest.getDomicilio())
                .sector(empleadoRequest.getSector())
                .computoDiasLicencias(empleadoRequest.getComputoDiasLicencias())
                .remanenteDiasLicencias(empleadoRequest.getRemanenteDiasLicencias())
                .documentoIdentidad(empleadoRequest.getDocumentoIdentidad())
                .build();
        try {
            empleadoService.save(empleado1);
        } catch (Exception e) {
            System.out.println("El error es " + e);
        }

        return new ResponseEntity(new Message("Empleado creado"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmpleadoResponse> update(Long id, EmpleadoRequest empleadoRequest)
            throws Exception {

        if (empleadoService.findById(id).equals(false)) {
            return new ResponseEntity(new Message("No existe"), HttpStatus.NOT_FOUND);
        }

        /*if (StringUtils.isBlank(empleadoRequest.getNombre())) {
            return new ResponseEntity(new Message("El nombre del Empleado es obligatorio"),
                    HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(empleadoRequest.getApellido())) {
            return new ResponseEntity(new Message("El apellido del Empleado es obligatorio"),
                    HttpStatus.BAD_REQUEST);
        }*/

        Empleado empleado = empleadoService.findById(id);
        Domicilio domicilio = new Domicilio();


        empleado.setSector(empleadoRequest.getSector());
        empleado.setRegimenHorario(empleadoRequest.getRegimenHorario());
        empleado.setRemuneracion(empleadoRequest.getRemuneracion());

        domicilio.setCalle(empleadoRequest.getDomicilio().getCalle());
        domicilio.setNroCalle(empleadoRequest.getDomicilio().getNroCalle());
        domicilio.setNroDepartamento(empleadoRequest.getDomicilio().getNroDepartamento());
        domicilio.setNroPiso(empleadoRequest.getDomicilio().getNroPiso());
        domicilio.setProvincia(empleadoRequest.getDomicilio().getProvincia());
        domicilio.setDepartamento(empleadoRequest.getDomicilio().getDepartamento());
        domicilio.setLocalidad(empleadoRequest.getDomicilio().getLocalidad());


        empleado.setCorreoPersonal(empleadoRequest.getCorreoPersonal());
        empleado.setNroTelefonoCelular(empleadoRequest.getNroTelefonoCelular());
        empleado.setNroTelefonoFijo(empleadoRequest.getNroTelefonoFijo());
        empleado.setDomicilio(domicilio);


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
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }

        Empleado empleado = empleadoService.getByfk_usuario(user.getId());
        EmpleadoResponse empleadoResponse = modelMapper.map(empleado, EmpleadoResponse.class);
        return new ResponseEntity(empleadoResponse, HttpStatus.OK);
    }

    public void createUser(EmpleadoRequest empleadoRequest) throws Exception {

        String aux_password = "";
        ModelMapper mapper = new ModelMapper();
        Empleado employee = mapper.map(empleadoRequest, Empleado.class);
        employee.setFechaAlta(new Date());

        aux_password = this.generateRandomPassword();

        employee.getUsuario().setPassword(passwordEncoder.encode(aux_password));
        empleadoService.save(employee);
        emailController.sendWelcomeEmail(
                this.preparingEmailData(employee.getUsuario().getUsername(), aux_password,
                        employee.getCorreoPersonal()));

    }

    private EmailValuesDTO preparingEmailData(String username, String password,
                                              String personalEmail) {
        EmailValuesDTO emailValuesDTO = EmailValuesDTO.builder().username(username).password(password)
                .mailTo(personalEmail).build();

        return emailValuesDTO;
    }

    private String generateRandomPassword() {

        String lowCases = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
        String capitalLetters = lowCases.toUpperCase(Locale.ROOT);
        String digits = "0,1,2,3,4,5,6,7,8,9";
        String nonAlphanumerics = "!,#,$,%,^,&,/,?,Â¿,-,<,>";

        String[] lowCasesArray = lowCases.split(",");
        String[] capitalLettersArray = capitalLetters.split(",");
        String[] digitsArray = digits.split(",");
        String[] nonAlphanumericsArray = nonAlphanumerics.split(",");

        Random rand = new Random();
        String password = "";
        String newPassword = "";
        String passwordArray[];

        if (this.lowerCasesAmount > 0) {
            for (int counter = 0; counter < this.lowerCasesAmount; counter++) {
                if (counter == 0) {
                    password = lowCasesArray[rand.nextInt(lowCasesArray.length)];
                } else {
                    password = lowCasesArray[rand.nextInt(lowCasesArray.length)] + "," + password;
                }
            }
        }

        if (this.capitalLettersAmount > 0) {
            for (int counter = 0; counter < this.capitalLettersAmount; counter++) {
                password = capitalLettersArray[rand.nextInt(capitalLettersArray.length)] + "," + password;
            }
        }

        if (this.digitsAmount > 0) {
            for (int counter = 0; counter < this.digitsAmount; counter++) {
                password = digitsArray[rand.nextInt(digitsArray.length)] + "," + password;
            }
        }

        if (this.nonAlphanumericsAmount > 0) {
            for (int counter = 0; counter < this.nonAlphanumericsAmount; counter++) {
                password =
                        nonAlphanumericsArray[rand.nextInt(nonAlphanumericsArray.length)] + "," + password;
            }
        }

        passwordArray = password.split(",");

        if (passwordArray.length > 0) {
            int[] exist = new int[passwordArray.length];

            for (int setter = 0; setter < exist.length; setter++) {
                exist[setter] = exist.length + 10;
            }

            int counter = 0;

            for (String letter : passwordArray) {
                int winner = 0;
                boolean passed = false;

                do {
                    winner = rand.nextInt(passwordArray.length);

                    for (int num : exist) {
                        if (winner != num) {
                            passed = true;
                        } else {
                            passed = false;
                            break;
                        }
                    }

                    if (passed) {
                        newPassword += passwordArray[winner];

                        exist[counter] = winner;
                        counter += 1;
                    }

                } while (!passed);
            }
        }
        return newPassword;
    }


}
