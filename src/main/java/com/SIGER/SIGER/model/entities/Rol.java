/*package com.SIGER.SIGER.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rol extends BaseEntity{
	
	private String codigoRol;

	private String nombreRol;
	
	//Relation
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "rol_permiso", 
	joinColumns = @JoinColumn(name = "rol_id"),
	inverseJoinColumns = @JoinColumn(name = "permiso_id"))
	private List<Permiso> permisos = new ArrayList<Permiso>();

}*/