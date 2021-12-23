package com.SIGER.SIGER.model.entities.direccion;

import com.SIGER.SIGER.model.entities.BaseEntity;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "paises")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Pais extends BaseEntity {

  private String nombre;

  private String name;

  private String nom;

  private String iso2;

  private String iso3;

  private String codigoNumerico;

  private String phone_code;

}
