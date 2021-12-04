package com.SIGER.SIGER.model.entities;
import java.util.Date;

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
public class Comentario extends BaseEntity{

	private String descripcion;
	
	private Date fecha;

}
