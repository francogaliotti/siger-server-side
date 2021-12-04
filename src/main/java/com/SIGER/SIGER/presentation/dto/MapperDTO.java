package com.SIGER.SIGER.presentation.dto;

import com.SIGER.SIGER.model.entities.BaseEntity;
import com.SIGER.SIGER.model.responses.BaseResponse;
import com.google.gson.Gson;

public class MapperDTO {

    public static BaseResponse MapperToDTO(BaseEntity entity, BaseResponse dto){

        String aux_entity = new Gson().toJson(entity);

        dto = new Gson().fromJson(aux_entity, dto.getClass());

        return dto;
    }

    /*public static <DTO, E> DTO MapperEntityToDTO(E fromEntity, DTO toDto){

        String aux_entity = new Gson().toJson(fromEntity);

        toDto = (DTO)new Gson().fromJson(aux_entity, toDto.getClass());

        return toDto;
    }*/
}
