package com.SIGER.SIGER.security.entity;

import com.SIGER.SIGER.model.entities.BaseEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Usuario extends BaseEntity {

    @NotNull
    private String nombre;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private String image;

    private String tokenPassword;

    @NotNull
    private boolean isFirstSignin;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    @NotNull
    private Set<Rol> roles = new HashSet<>();
}
