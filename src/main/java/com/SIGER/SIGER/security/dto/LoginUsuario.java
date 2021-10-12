package com.SIGER.SIGER.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginUsuario {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
