package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.dto.TipoLicenciaDTO;
import com.SIGER.SIGER.entities.TipoLicencia;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.servicesImpl.TipoLicenciaServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TipoLicenciaExpert {
    @Autowired
    TipoLicenciaServiceImpl tipoLicenciaServiceImpl;

    public ResponseEntity<?> getAll() {
        List<TipoLicencia> list = null;
        try {
            list = tipoLicenciaServiceImpl.FindAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelMapper modelMapper = new ModelMapper();
        List<TipoLicenciaDTO> tipoLicenciaDTOS = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            tipoLicenciaDTOS.add(modelMapper.map(list.get(i), TipoLicenciaDTO.class));
        }
        return new ResponseEntity(tipoLicenciaDTOS, HttpStatus.OK);
    }


    public ResponseEntity<?> getOne(Long id) {
        try {
            if(tipoLicenciaServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TipoLicencia tipoLicencia = null;
        try{
            tipoLicencia = tipoLicenciaServiceImpl.FindById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(tipoLicencia, HttpStatus.OK);
    }


    public ResponseEntity<?> save(TipoLicenciaDTO tipoLicenciaDTO) throws Exception {
        if(StringUtils.isBlank(tipoLicenciaDTO.getDenominacion()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(tipoLicenciaDTO.getCodigo().length()<0)
            return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(tipoLicenciaDTO.getTipoRequerimientoDenominacion()))
            return new ResponseEntity(new Mensaje("La denominación del tipo de Requerimiento es obligatoria"), HttpStatus.BAD_REQUEST);
        if(tipoLicenciaServiceImpl.existsByNombreTipoLicencia(tipoLicenciaDTO.getDenominacion()))
            return new ResponseEntity(new Mensaje("El nombre del tipo ya existe"), HttpStatus.BAD_REQUEST);
        ModelMapper modelMapper = new ModelMapper();
        TipoLicencia tipoLicencia = modelMapper.map(tipoLicenciaDTO,TipoLicencia.class);
        try{
            tipoLicenciaServiceImpl.Save(tipoLicencia);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Tipo de licencia creado"),HttpStatus.OK);
    }


    public ResponseEntity<?> update(Long id, TipoLicenciaDTO tipoLicenciaDTO) {
        try {
            if(tipoLicenciaServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if(StringUtils.isBlank(tipoLicenciaDTO.getDenominacion()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(tipoLicenciaDTO.getCodigo().length()<0)
            return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(tipoLicenciaDTO.getTipoRequerimientoDenominacion()))
            return new ResponseEntity(new Mensaje("La denominación del tipo de Requerimiento es obligatoria"), HttpStatus.BAD_REQUEST);
        /*ModelMapper modelMapper = new ModelMapper();
        TipoLicencia tipoLicencia = modelMapper.map(tipoLicenciaDTO,TipoLicencia.class);*/
        try {
            TipoLicencia tipoLicencia = tipoLicenciaServiceImpl.FindById(id);
            tipoLicencia.setCodigo(tipoLicenciaDTO.getCodigo());
            tipoLicencia.setDenominacion(tipoLicenciaDTO.getDenominacion());
            tipoLicencia.setGeneraRequerimiento(tipoLicenciaDTO.getGeneraRequerimiento());
            tipoLicencia.setJustificaRequerimiento(tipoLicenciaDTO.getJustificaRequerimiento());
            tipoLicencia.setLimiteRangoDias(tipoLicenciaDTO.getLimiteRangoDias());
            tipoLicencia.setModalidadLicencia(tipoLicenciaDTO.getModalidadLicencia());
            tipoLicencia.setObservaciones(tipoLicenciaDTO.getObservaciones());
            tipoLicencia.setPermiteSolapamiento(tipoLicenciaDTO.getPermiteSolapamiento());
            tipoLicencia.setTipoCalculo(tipoLicenciaDTO.getTipoCalculo());
            tipoLicencia.getTipoRequerimiento().setTipoRequerimientoDenominacion(tipoLicenciaDTO.getTipoRequerimientoDenominacion());
            tipoLicencia.getTipoRequerimiento().setCantNiveles(tipoLicenciaDTO.getTipoRequerimientoCantNiveles());
            tipoLicenciaServiceImpl.Update(id, tipoLicencia);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Tipo de Licencia actualizado"), HttpStatus.OK);
    }


    public ResponseEntity<?> delete(Long id) {
        try {
            if(tipoLicenciaServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {
            tipoLicenciaServiceImpl.Delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Tipo Licencia eliminado"), HttpStatus.OK);
    }
}
