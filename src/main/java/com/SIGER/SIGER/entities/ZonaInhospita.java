package com.SIGER.SIGER.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

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
public class ZonaInhospita extends BaseEntity{

	private String codZona;

	private String denominacionZona;
	
	private float precio;

}