package com.SIGER.SIGER.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DTORegister {

    private String username;

    private String password;

    private String correoInstitucional;

    private String rolNecesario;

    private boolean esPrimerInicio;

    private boolean	enabled;

    private boolean requiereAutorizacion;

    private boolean recordarme;

}
