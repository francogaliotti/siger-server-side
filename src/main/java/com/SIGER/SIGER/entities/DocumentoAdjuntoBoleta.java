package com.SIGER.SIGER.entities;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DocumentoAdjuntoBoleta extends BaseEntity{

	private String urlDocumentoAdjuntoBoleta;
	
	private String extencionDocumentoAdjuntoBoleta;

}
