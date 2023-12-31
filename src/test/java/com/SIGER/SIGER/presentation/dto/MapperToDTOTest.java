package com.SIGER.SIGER.presentation.dto;

import com.SIGER.SIGER.model.responses.UsuarioResponse;
import com.SIGER.SIGER.security.entity.Usuario;
import com.SIGER.SIGER.servicesInterfaces.BaseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest(classes = BaseService.class)
public class MapperToDTOTest {

    @Test
    void contextLoads() {

        Usuario user = Usuario.builder().username("jperez").password("jperez1234").correoInstitucional("jperez@dpv.com.ar").build();

        UsuarioResponse dto_user = (UsuarioResponse) MapperDTO.MapperToDTO(user, new UsuarioResponse());

        Assert.isTrue(user.getUsername().equals(dto_user.getUsername()), "");
        Assert.isTrue(user.getPassword().equals(dto_user.getPassword()), "");
        Assert.isTrue(user.getCorreoInstitucional().equals(dto_user.getCorreoInstitucional()),"");

    }

}
