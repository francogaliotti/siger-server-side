package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.model.responses.BaseResponse;
import com.SIGER.SIGER.security.entity.Rol;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRequest extends BaseResponse {

     String username;

     String password;

     String correoInstitucional;

     String rolNecesario;

     boolean esPrimerInicio;

     boolean	enabled;

     boolean requiereAutorizacion;

     boolean recordarme;

     List<Rol> roles = new ArrayList<Rol>();

     public UsuarioRequest(){
         super();
     }

}
