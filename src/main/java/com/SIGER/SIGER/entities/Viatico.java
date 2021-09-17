package com.SIGER.SIGER.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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

/* nueva rama de viatico */
public class Viatico extends BaseEntity{

	private String codViatico;

	private String denominacionViatico;
	
	private double importe;

}