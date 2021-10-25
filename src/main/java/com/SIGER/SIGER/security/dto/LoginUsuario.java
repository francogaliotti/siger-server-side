package com.SIGER.SIGER.security.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginUsuario {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
