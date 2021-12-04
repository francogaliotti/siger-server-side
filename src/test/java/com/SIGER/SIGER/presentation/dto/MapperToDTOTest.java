package com.SIGER.SIGER.presentation.dto;

import com.SIGER.SIGER.security.entity.Usuario;
import com.SIGER.SIGER.servicesInterfaces.BaseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest(classes = BaseService.class)
public class MapperToDTOTest {

    @Test
    void contextLoads() {

        Usuario user = Usuario.builder().username("jperez").password("jperez1234").email("jperez@dpv.com.ar").build();

        UsuarioResponse dto_user = (UsuarioResponse) MapperDTO.MapperToDTO(user, new UsuarioResponse());

        Assert.isTrue(user.getUsername().equals(dto_user.username), "");
        Assert.isTrue(user.getPassword().equals(dto_user.password), "");
        Assert.isTrue(user.getEmail().equals(dto_user.correoInstitucional),"");

    }

}
