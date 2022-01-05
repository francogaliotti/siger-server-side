package com.SIGER.SIGER.model.entities;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass// No transmite la persistencia de la herencia a la base de datos, solo lo representa en POO
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private boolean softDelete;
	
}
