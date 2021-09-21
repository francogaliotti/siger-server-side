package com.SIGER.SIGER.presentation.dto;

import com.SIGER.SIGER.entities.BaseEntity;
import com.google.gson.Gson;

public class MapperDTO {

    public static BaseEntityDTO MapperToDTO(BaseEntity entity, BaseEntityDTO dto){

        String aux_entity = new Gson().toJson(entity);

        dto = new Gson().fromJson(aux_entity, dto.getClass());

        return dto;
    }
}
