package com.SIGER.SIGER.model.responses;

import com.SIGER.SIGER.security.entity.Rol;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class UsuarioResponse extends BaseResponse {

     private String username;

     private String password;

     private String correoInstitucional;

     private  String rolNecesario;

     private boolean esPrimerInicio;

     private  boolean	enabled;

     private  boolean requiereAutorizacion;
     private boolean recordarme;

     private List<Rol> roles = new ArrayList<Rol>();

     public UsuarioResponse(){
         super();
     }

}
