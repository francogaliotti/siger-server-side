package com.SIGER.SIGER.entities;

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
public class ComputoDiasLicencia extends BaseEntity{

	private int antiguedad;
	
	private int diasLicencia;
	
}
