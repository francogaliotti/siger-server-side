package com.SIGER.SIGER.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TipoLicenciaDTO {
    @Id
    @Column(name = "id", nullable = false)

    private int cantidadMaximaAnual;

    private int cantidadMaximaDiaria;

    private int cantidadMaximaMensual;

    private String codigo;

    private String denominacion;

    private char generaRequerimiento;

    private char justificaRequerimiento;

    private int limiteRangoDias;

    private String modalidadLicencia;

    private String observaciones;

    private char permiteSolapamiento;

    private String tipoCalculo;

    public int tipoRequerimientoCantidadNiveles;

    public String tipoRequerimientoDenominacion;


}