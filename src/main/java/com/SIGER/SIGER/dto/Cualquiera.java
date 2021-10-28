package com.SIGER.SIGER.dto;

import com.SIGER.SIGER.entities.TipoRequerimiento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cualquiera  {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public String codigo;
    public String denominacion;
    public String observaciones;
    public String cantNiveles;
    public String denomTR;
    public Long  sectores;
    public Long [] autorizadores;

    public Long getAutorizador(int i){
        return autorizadores[i];
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
