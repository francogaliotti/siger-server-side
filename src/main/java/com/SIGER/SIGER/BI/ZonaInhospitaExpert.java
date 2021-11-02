package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.entities.ZonaInhospita;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.servicesImpl.ZonaInhospitaServiceImpl;
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
public class ZonaInhospitaExpert {
    @Autowired
    ZonaInhospitaServiceImpl zonaInhospitaServiceImpl ;

    public ResponseEntity<?> getAll() {
        List<ZonaInhospita> list = null;
        try{
            list = zonaInhospitaServiceImpl.FindAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    public ResponseEntity<?> getAll(Pageable pageable) {
        List<ZonaInhospita> zonaInhospitas = null;
        try {
            zonaInhospitas = zonaInhospitaServiceImpl.FindAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(zonaInhospitas, HttpStatus.OK);
    }

    public ResponseEntity<?> getOne(Long id) {
        try {
            if(zonaInhospitaServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ZonaInhospita zonaInhospita = null;

        try{
            zonaInhospita = zonaInhospitaServiceImpl.FindById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(zonaInhospita, HttpStatus.OK);
    }

    public ResponseEntity<?> save(ZonaInhospita zonaInhospita) {
        try{
            zonaInhospita = zonaInhospitaServiceImpl.Save(zonaInhospita);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Zona Inhóspita creada"), HttpStatus.OK);
    }

    public ResponseEntity<?> update(Long id, ZonaInhospita zonaInhospita) {
        try {
            if(zonaInhospitaServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        if(StringUtils.isBlank(zonaInhospita.getDenominacionZona()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(zonaInhospita.getCodZona().length()<0)
            return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

        try {
            ZonaInhospita zonaInhospita1 = zonaInhospitaServiceImpl.FindById(id);
            zonaInhospita1.setCodZona(zonaInhospita.getCodZona());
            zonaInhospita1.setDenominacionZona(zonaInhospita.getDenominacionZona());
            zonaInhospita1.setPrecio(zonaInhospita.getPrecio());
            zonaInhospitaServiceImpl.Update(id, zonaInhospita1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Zona Inhóspita actualizada"), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Long id) {
        try {
            if(zonaInhospitaServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            zonaInhospitaServiceImpl.Delete(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Zona Inhóspita eliminada"), HttpStatus.OK);
    }
}
