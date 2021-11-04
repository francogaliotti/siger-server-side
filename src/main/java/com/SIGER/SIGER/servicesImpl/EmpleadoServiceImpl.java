package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.entities.Empleado;
import com.SIGER.SIGER.repositories.EmpleadoRepository;
import com.SIGER.SIGER.services.EmpleadoService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado, Long> implements EmpleadoService {
	
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
  public Optional<Empleado> getByLegajo(int legajo) {
    return empleadoRepository.findByLegajo(legajo);
  }

  @Transactional
  public boolean existsByLegajo(int legajo) {
    return empleadoRepository.existsByLegajo(legajo);
  }

  @Transactional
  public Optional<Empleado> getByCuil(String cuil) {
    return empleadoRepository.findByCuil(cuil);
  }

  @Transactional
  public boolean existsByCuil(String cuil) {
    return empleadoRepository.existsByCuil(cuil);
  }

  @Transactional
  public Optional<Empleado> getByNroIdentificacionPersonal(String nroIdentificacionPersonal) {
    return empleadoRepository.findByNroIdentificacionPersonal(nroIdentificacionPersonal);
  }

  @Transactional
  public boolean existsByNroIdentificacionPersonal(String nroIdentificacionPersonal) {
    return empleadoRepository.existsByNroIdentificacionPersonal(nroIdentificacionPersonal);
  }

}
