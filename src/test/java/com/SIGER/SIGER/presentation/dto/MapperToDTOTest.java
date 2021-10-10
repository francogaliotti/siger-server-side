package com.SIGER.SIGER.presentation.dto;

import com.SIGER.SIGER.entities.Usuario;
import com.SIGER.SIGER.services.BaseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest(classes = BaseService.class)
public class MapperToDTOTest {

    @Test
    void contextLoads() {

        Usuario user = Usuario.builder().username("jperez").password("jperez1234").correoInstitucional("jperez@dpv.com.ar").build();

        UsuarioDTO dto_user = (UsuarioDTO) MapperDTO.MapperToDTO(user, new UsuarioDTO());

        Assert.isTrue(user.getUsername().equals(dto_user.username), "");
        Assert.isTrue(user.getPassword().equals(dto_user.password), "");
        Assert.isTrue(user.getCorreoInstitucional().equals(dto_user.correoInstitucional),"");

    }

}