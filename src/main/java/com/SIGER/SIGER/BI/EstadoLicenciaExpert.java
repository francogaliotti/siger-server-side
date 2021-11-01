package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.entities.EstadoLicencia;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.servicesImpl.EstadoLicenciaServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Component
public class EstadoLicenciaExpert {

    @Autowired
    EstadoLicenciaServiceImpl estadoLicenciaServiceImpl;

    public ResponseEntity<?> getAll() {
        List<EstadoLicencia> list = null;
        try{
            list = estadoLicenciaServiceImpl.FindAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }


    public ResponseEntity<?> getAll(Pageable pageable) {
        List<EstadoLicencia> estadosLicencia = null;
        try {
            estadosLicencia = estadoLicenciaServiceImpl.FindAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(estadosLicencia, HttpStatus.OK);
    }

    public ResponseEntity<?> getOne(Long id) {
        try {
            if(estadoLicenciaServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        EstadoLicencia estadoLicencia = null;

        try{
            estadoLicencia = estadoLicenciaServiceImpl.FindById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(estadoLicencia, HttpStatus.OK);
    }

    public ResponseEntity<?> save(EstadoLicencia estadoLicencia) {
        if(StringUtils.isBlank(estadoLicencia.getNombreEstadoLicencia()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(estadoLicencia.getCodEstadoLicencia().length()<0)
            return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        if(estadoLicenciaServiceImpl.existsByNombreEstadoLicencia(estadoLicencia.getNombreEstadoLicencia()))
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        try{
            estadoLicencia = estadoLicenciaServiceImpl.Save(estadoLicencia);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Estado de Licencia creado"), HttpStatus.OK);
    }

    public ResponseEntity<?> update(Long id, EstadoLicencia estadoLicencia) {
        try {
            if(estadoLicenciaServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if(StringUtils.isBlank(estadoLicencia.getNombreEstadoLicencia()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(estadoLicencia.getCodEstadoLicencia().length()<0)
            return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

        try {
            estadoLicenciaServiceImpl.Update(id, estadoLicencia);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Estado de Licencia actualizado"), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Long id) {
        try {
            if(estadoLicenciaServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {
            estadoLicenciaServiceImpl.Delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Estado de Licencia eliminado"), HttpStatus.OK);
    }
}
