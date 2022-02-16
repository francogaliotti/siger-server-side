package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.Empleado;
import com.SIGER.SIGER.repositories.EmpleadoRepository;
import com.SIGER.SIGER.servicesInterfaces.IEmpleadoService;

import java.util.Optional;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService extends AbsBaseService<Empleado, Long> implements
        IEmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Transactional
    public Optional<Empleado> getByNombre(String nombre) {
        return empleadoRepository.findByNombre(nombre);
    }

    @Transactional
    public boolean existsByNombre(String nombre) {
        return empleadoRepository.existsByNombre(nombre);
    }

    @Transactional
    public Optional<Empleado> getByApellido(String nombre) {
        return empleadoRepository.findByApellido(nombre);
    }

    @Transactional
    public boolean existsByApellido(String apellido) {
        return empleadoRepository.existsByApellido(apellido);
    }

    @Transactional
    public Optional<Empleado> getByLegajo(String legajo) {
        return empleadoRepository.findByLegajo(legajo);
    }

    @Transactional
    public boolean existsByLegajo(String legajo) {
        return empleadoRepository.existsByLegajo(legajo);
    }

    public Empleado getByfk_usuario(Long id) {
        return empleadoRepository.findByUsuario(id);
    }

    @Transactional
    public boolean alreadyExistPersonalEmail(String personalEmail) {
        return empleadoRepository.existsByCorreoPersonal(personalEmail);
    }

    @Transactional
    public boolean alreadyExistDocumentNumber(String documentNumber, Long docType){
        Optional<Boolean> aux = empleadoRepository.existByNroIdentidad(documentNumber, docType);
        boolean exist = false;
        if(aux.isPresent()) exist = true;

        return  exist;
    }
}
