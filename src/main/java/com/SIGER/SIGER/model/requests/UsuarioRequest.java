package com.SIGER.SIGER.model.requests;

import com.SIGER.SIGER.model.responses.BaseResponse;
import com.SIGER.SIGER.security.entity.Rol;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest extends BaseResponse {

     String username;

     String correoInstitucional;

     String password;

     private String image;

     String rolNecesario;

     private boolean isFirstSignin;

     boolean	enabled;

     boolean requiereAutorizacion;

     boolean recordarme;

     List<Rol> roles = new ArrayList<Rol>();

     public UsuarioRequest(){
         super();
     }

}
