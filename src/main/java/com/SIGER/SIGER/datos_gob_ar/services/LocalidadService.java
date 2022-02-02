package com.SIGER.SIGER.datos_gob_ar.services;

import com.SIGER.SIGER.datos_gob_ar.entities.Localidad;
import com.SIGER.SIGER.datos_gob_ar.repositories.LocalidadRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadService {

  @Autowired
  LocalidadRepository localidadRepository;

  @Transactional
  public Page<Localidad> findAll(int page, int size, Long id) throws Exception {
    Pageable pageable = PageRequest.of(page, size);
    return localidadRepository.findByDepartamento(pageable, id);

  }

  @Transactional
  public List<Localidad> findAll(Long id) throws Exception {
    return localidadRepository.getByDepartamento(id);

  }

}
