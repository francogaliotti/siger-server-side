package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.entities.Permiso;
import com.SIGER.SIGER.services.PermisoServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permiso")
@CrossOrigin(origins = "http://localhost:4200")
public class PermisoController extends BaseControllerImpl<Permiso, PermisoServiceImpl> {
    @Autowired
    PermisoServiceImpl permisoServiceImpl;

    @GetMapping("/list")
    public ResponseEntity<List<Permiso>> getAll(){
        List<Permiso> list= permisoServiceImpl.list();
        return new ResponseEntity<List<Permiso>>(list, HttpStatus.OK);
    }

    @GetMapping("/detail-name/{nombre}")
    public ResponseEntity<Permiso> getByNombre(@PathVariable("nombre") String nombrePermiso){
        if(!permisoServiceImpl.existByNombrePermiso(nombrePermiso))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Permiso permiso = permisoServiceImpl.getByNombrePermiso(nombrePermiso).get();
        return new ResponseEntity(permiso, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Permiso> getOne(@PathVariable("id") Long id){
        if(!permisoServiceImpl.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Permiso permiso = permisoServiceImpl.getById(id).get();
        return new ResponseEntity(permiso, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<?> save(Permiso entity) {
        if(StringUtils.isBlank(entity.getNombrePermiso()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(entity.getCodigoPermiso().length()<0)
            return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

        try {
            entity = permisoServiceImpl.Save(entity);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Permiso creado"), HttpStatus.OK);
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(Long id, Permiso entity) {
        try {
            if(permisoServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        if(StringUtils.isBlank(entity.getNombrePermiso()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(entity.getCodigoPermiso().length()<0)
            return new ResponseEntity(new Mensaje("El codigo es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);

        try {
            permisoServiceImpl.Save(entity);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Permiso actualizado"), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        try {
            if(permisoServiceImpl.getById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            permisoServiceImpl.Delete(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Permiso eliminado"), HttpStatus.OK);
    }
}
