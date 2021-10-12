/*package com.SIGER.SIGER.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
public class Rol extends BaseEntity{
	
	private String codigoRol;

	private String nombreRol;
	
	//Relation
	
	@ManyToMany(cascade = {/*CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "rol_permiso", 
	joinColumns = @JoinColumn(name = "rol_id"),
	inverseJoinColumns = @JoinColumn(name = "permiso_id"))
	private List<Permiso> permisos = new ArrayList<Permiso>();

}*/