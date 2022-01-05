package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.model.entities.Nacionalidad;
import com.SIGER.SIGER.model.entities.TipoBoleta;
import com.SIGER.SIGER.model.requests.NacionalidadRequest;
import com.SIGER.SIGER.model.requests.TipoBoletaRequest;
import com.SIGER.SIGER.model.responses.NacionalidadResponse;
import com.SIGER.SIGER.model.responses.TipoBoletaResponse;
import com.SIGER.SIGER.services.NacionalidadService;
import com.SIGER.SIGER.services.TipoBoletaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NacionalidadExpert extends AbsBaseExpert<Nacionalidad, NacionalidadService, NacionalidadRequest, NacionalidadResponse> {

    @Autowired
    private NacionalidadService nationalityService;

    public ResponseEntity<List<NacionalidadResponse>> GetAll() throws Exception{
       List<Nacionalidad> nationalities =  nationalityService.findAll();

       List<NacionalidadResponse> nationalitiesDTO = new ArrayList<NacionalidadResponse>();
       for (Nacionalidad nationality: nationalities) {
            nationalitiesDTO.add(modelMapper.map(nationality, NacionalidadResponse.class));
        }

       return new ResponseEntity<>(nationalitiesDTO, HttpStatus.OK);
    }
}
