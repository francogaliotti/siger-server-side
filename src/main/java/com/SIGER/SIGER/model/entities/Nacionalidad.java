package com.SIGER.SIGER.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Nacionalidad extends BaseEntity {
    private String nombre;
}
