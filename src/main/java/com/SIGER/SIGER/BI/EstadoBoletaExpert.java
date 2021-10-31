package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.entities.EstadoBoleta;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.servicesImpl.EstadoBoletaServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class EstadoBoletaExpert {

    @Autowired
    EstadoBoletaServiceImpl estadoboletaServiceImpl;

    public ResponseEntity<List<EstadoBoleta>> getAll() {
        List<EstadoBoleta> list = null;
        try {
            list = estadoboletaServiceImpl.FindAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    public ResponseEntity<?> getOne(Long id) {
        try {
            if(estadoboletaServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        EstadoBoleta estadoBoleta = null;
        try {
            estadoBoleta = estadoboletaServiceImpl.FindById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(estadoBoleta, HttpStatus.OK);
    }

    public ResponseEntity<EstadoBoleta> getByNombre(@PathVariable("nombre") String nombreEstadoBoleta){
        if(!estadoboletaServiceImpl.existsByNombreEstadoBoleta(nombreEstadoBoleta))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        EstadoBoleta estadoBoleta = estadoboletaServiceImpl.getByNombreEstadoBoleta(nombreEstadoBoleta).get();
        return new ResponseEntity(estadoBoleta, HttpStatus.OK);
    }

    public ResponseEntity<?> save(EstadoBoleta estadoBoleta) {
        if(StringUtils.isBlank(estadoBoleta.getNombreEstadoBoleta()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(estadoBoleta.getCodEstadoBoleta().length()<0)
            return new ResponseEntity(new Mensaje("El código es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        if(estadoboletaServiceImpl.existsByNombreEstadoBoleta(estadoBoleta.getNombreEstadoBoleta()))
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        EstadoBoleta estadoBoletaNew = EstadoBoleta.builder().codEstadoBoleta(estadoBoleta.getCodEstadoBoleta()).
                nombreEstadoBoleta(estadoBoleta.getNombreEstadoBoleta()).build();
        try {
            estadoboletaServiceImpl.Save(estadoBoletaNew);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Estado de Boleta creado"), HttpStatus.OK);
    }

    public ResponseEntity<?> update(Long id, EstadoBoleta estadoBoleta) {
        try {
            if(estadoboletaServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if(StringUtils.isBlank(estadoBoleta.getNombreEstadoBoleta()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(estadoBoleta.getCodEstadoBoleta().length()<0)
            return new ResponseEntity(new Mensaje("El código es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

        try {
            estadoboletaServiceImpl.Update(id, estadoBoleta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Estado de Boleta actualizado"), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Long id) {
        try {
            if(estadoboletaServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {
            estadoboletaServiceImpl.Delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Estado de Boleta eliminado"), HttpStatus.OK);
    }
}
