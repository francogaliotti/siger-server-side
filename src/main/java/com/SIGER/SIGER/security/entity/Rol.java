package com.SIGER.SIGER.security.entity;

import com.SIGER.SIGER.entities.BaseEntity;
import com.SIGER.SIGER.security.enums.RolNombre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rol extends BaseEntity {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;*/

    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
