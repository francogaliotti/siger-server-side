package com.SIGER.SIGER.model.responses;

import com.SIGER.SIGER.model.entities.*;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonRootName("Licencia")
@Getter
@Setter
public class LicenciaResponse extends BaseResponse{
    private Date fechaAlta;

    private Date fechaBaja;

    private LocalDateTime fechaInicioLicencia;

    private LocalDateTime fechaFinLicencia;

    private Date fechaFrancoCompensatorio;

    private Date fechaCierre;

    private Date fechaControl;

    private Date fechaSincronizacion;

    private String observacionesLicencia;

    private String mensajeRechazo;

    private List<Comentario> comentarios = new ArrayList<>();

    private List<DocumentoAdjuntoLicencia> documentosAdjuntosLicencia = new ArrayList<>();

    private TipoLicencia tipoLicencia;

    private List<FechaCambioEstadoLicencia> fechasCambioEstadoLicencia = new ArrayList<>();

    private Empleado empleado;

}
