package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.entities.Viatico;
import com.SIGER.SIGER.presentation.dto.Mensaje;
import com.SIGER.SIGER.servicesImpl.ViaticoServiceImpl;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ViaticoExpert {

    @Autowired
    ViaticoServiceImpl viaticoServiceImpl;

    public ResponseEntity<List<Viatico>> getAll() {
        List<Viatico> viaticos = null;
        try {
            viaticos = viaticoServiceImpl.FindAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity(viaticos, HttpStatus.OK);
    }

    public ResponseEntity<?> getOne(Long id) {
        try {
            if(viaticoServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Viatico viatico = null;
        try {
            viatico = viaticoServiceImpl.FindById(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity(viatico, HttpStatus.OK);
    }

    public ResponseEntity<Viatico> getByNombre(String denominacionViatico){
        if(!viaticoServiceImpl.existByDenominacionViatico(denominacionViatico))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Viatico viatico = viaticoServiceImpl.getByDenominacionViatico(denominacionViatico).get();
        return new ResponseEntity(viatico, HttpStatus.OK);
    }

    public ResponseEntity<?> save(Viatico viatico) {
        if(StringUtils.isBlank(viatico.getDenominacionViatico()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(viatico.getCodViatico().length()<0)
            return new ResponseEntity(new Mensaje("El código es obligatorio"), HttpStatus.BAD_REQUEST);
        if(viaticoServiceImpl.existByDenominacionViatico(viatico.getDenominacionViatico()))
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(viatico.getImporte()<0)
            return new ResponseEntity(new Mensaje("El importe debe ser positivo"), HttpStatus.BAD_REQUEST);
        Viatico viatico1 = Viatico.builder().codViatico(viatico.getCodViatico())
                .denominacionViatico(viatico.getDenominacionViatico())
                .importe(viatico.getImporte()).build();
        try {
            viaticoServiceImpl.Save(viatico1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Viatico creado"), HttpStatus.OK);
    }

    public ResponseEntity<?> update(Long id, Viatico viatico) {
        try {
            if(viaticoServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        if(StringUtils.isBlank(viatico.getDenominacionViatico()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(viatico.getCodViatico().length()<0)
            return new ResponseEntity(new Mensaje("El código es obligatorio, o debe ser mayor a 0"), HttpStatus.BAD_REQUEST);
        if(viatico.getImporte()<0)
            return new ResponseEntity(new Mensaje("El importe debe ser positivo"), HttpStatus.BAD_REQUEST);

        try {
            Viatico viatico1 = viaticoServiceImpl.FindById(id);
            viatico1.setCodViatico(viatico.getCodViatico());
            viatico1.setDenominacionViatico(viatico.getDenominacionViatico());
            viatico1.setImporte(viatico.getImporte());
            viaticoServiceImpl.Update(id, viatico1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Viatico actualizado"), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(Long id) {
        try {
            if(viaticoServiceImpl.FindById(id).equals(false))
                return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            viaticoServiceImpl.Delete(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity(new Mensaje("Viatico eliminado"), HttpStatus.OK);
    }


}
