package com.SIGER.SIGER.security.entity;

import com.SIGER.SIGER.model.entities.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Usuario extends BaseEntity {

    @NotNull
    private String nombre;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String correoInstitucional;

    @NotNull
    private String password;

    private LocalDateTime passwordExpireDate;

    private String image;

    private String tokenPassword;

    @NotNull
    private boolean isFirstSignIn;

    boolean	enabled;

    boolean requiereAutorizacion;

    boolean recordarme;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    @NotNull
    private Set<Rol> roles = new HashSet<>();
}
