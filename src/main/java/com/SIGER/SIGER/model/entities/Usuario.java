/*package com.SIGER.SIGER.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Usuario extends BaseEntity{

	private String username;

	private String password;
	
	private String correoInstitucional;

	private String rolNecesario;

	private boolean esPrimerInicio;
	
	private boolean	enabled;
	
	private boolean requiereAutorizacion;

	private boolean recordarme;

	//Relation
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
			@JoinTable(name = "usuario_rol", 
			joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private List<Rol> roles = new ArrayList<Rol>();

}*/