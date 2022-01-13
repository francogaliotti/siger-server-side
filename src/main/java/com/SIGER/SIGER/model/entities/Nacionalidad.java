package com.SIGER.SIGER.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Nacionalidad extends BaseEntity {

    @Column(name = "PAIS_NAC", nullable = false)
    private String pais_nac;

    @Column(name = "GENTILICIO_NAC", nullable = false)
    private String nombre;

    @Column(name = "ISO_NAC", nullable = false)
    private String iso_nac;
}
