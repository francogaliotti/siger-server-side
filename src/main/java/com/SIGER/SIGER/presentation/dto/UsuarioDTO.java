package com.SIGER.SIGER.presentation.dto;

import com.SIGER.SIGER.security.entity.Rol;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO extends BaseEntityDTO{

     String username;

     String password;

     String correoInstitucional;

     String rolNecesario;

     boolean esPrimerInicio;

     boolean	enabled;

     boolean requiereAutorizacion;

     boolean recordarme;

     List<Rol> roles = new ArrayList<Rol>();

     public UsuarioDTO(){
         super();
     }

}
