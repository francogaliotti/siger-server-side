package com.SIGER.SIGER.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DocumentoIdentidad extends BaseEntity {
    private String nroIdentidad;

    @OneToOne(cascade = CascadeType.MERGE)
    private TipoDocumento tipoDocumento;
}
