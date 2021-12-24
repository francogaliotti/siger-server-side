package com.SIGER.SIGER.model.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DocumentoAdjuntoBoleta extends BaseEntity{

	private String urlDocumentoAdjuntoBoleta;
	
	private String extencionDocumentoAdjuntoBoleta;

}
