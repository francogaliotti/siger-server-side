package com.SIGER.SIGER.presentation.dto;


import com.SIGER.SIGER.model.entities.Permiso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RolDTO {
    private int codigoRol;
    private String nombreRol;
    private List<Permiso> permisos = new ArrayList<Permiso>();
}
