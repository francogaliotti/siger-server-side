package com.SIGER.SIGER.datos_gob_ar.services;

import com.SIGER.SIGER.datos_gob_ar.entities.Municipio;
import com.SIGER.SIGER.datos_gob_ar.repositories.MunicipioRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService {

  @Autowired
  MunicipioRepository municipioRepository;

  @Transactional
  public Page<Municipio> findAll(int page, int size, Long id) throws Exception {
    Pageable pageable = PageRequest.of(page, size);
    return municipioRepository.findByProvincia(pageable, id);

  }

}
