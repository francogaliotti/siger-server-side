package com.SIGER.SIGER.model.responses;

import com.SIGER.SIGER.model.entities.*;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonRootName("Licencia")
@Getter
@Setter
public class LicenciaResponse extends BaseResponse{
    private Date fechaAlta;

    private Date fechaBaja;

    private Date fechaInicioLicencia;

    private Date fechaFinLicencia;

    private Date fechaFrancoCompensatorio;

    private Date fechaCierre;

    private Date fechaControl;

    private Date fechaSincronizacion;

    private String observacionesLicencia;

    private List<Comentario> comentarios = new ArrayList<>();

    private List<DocumentoAdjuntoLicencia> documentosAdjuntosLicencia = new ArrayList<>();

    private TipoLicencia tipoLicencia;

    private List<FechaCambioEstadoLicencia> fechasCambioEstadoLicencia = new ArrayList<>();

    private Empleado empleado;

}
