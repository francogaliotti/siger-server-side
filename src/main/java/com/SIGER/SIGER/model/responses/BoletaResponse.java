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

@JsonRootName("Boleta")
@Getter
@Setter
public class BoletaResponse extends BaseResponse{

    private Date fechaAlta;

    private Date fechaBaja;

    private String numero;

    private Date fechaHoraLlegada;

    private Date fechaHoraSalida;

    private Date fechaHoraPosibleLlegada;

    private Date fechaHoraPosibleSalida;

    private int periodo;

    private Date fechaCierre;

    private Date fechaControl;

    private String observacionesBoleta;

    private Date fechaSincronizacion;

    private boolean sinFichadaRetorno;

    private boolean sinFichadaSalida;

    //Relations

    private ZonaInhospita zonaInhospita;

    private Viatico viatico;

    private Empleado empleado;

    private List<FechaCambioEstadoBoleta> fechasCambioEstadoBoleta = new ArrayList<>();

    private List<DocumentoAdjuntoBoleta> documentosAdjuntosBoleta = new ArrayList<>();

    private List<Movilidad> movilidades = new ArrayList<>();

    private TipoBoleta tipoBoleta;

    private List<Comentario> comentarios = new ArrayList<>();
}
