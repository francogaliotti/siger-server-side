package com.SIGER.SIGER.model.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Viatico extends BaseEntity{

	private String codViatico;

	private String denominacionViatico;
	
	private double importe;

}