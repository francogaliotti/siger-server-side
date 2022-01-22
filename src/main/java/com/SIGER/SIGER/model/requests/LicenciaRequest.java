package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.model.entities.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class LicenciaRequest extends BaseRequest{

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
