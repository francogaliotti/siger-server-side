package com.SIGER.SIGER.datos_gob_ar.services;

import com.SIGER.SIGER.datos_gob_ar.entities.Provincia;
import com.SIGER.SIGER.datos_gob_ar.repositories.ProvinciaRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaService {

  @Autowired
  ProvinciaRepository provinciaRepository;

  @Transactional
  public Page<Provincia> findAll(int page, int size) throws Exception {
    Pageable pageable = PageRequest.of(page, size);
    return provinciaRepository.findAll(pageable);

  }
  public List<Provincia> findAll() throws Exception {
    return provinciaRepository.findAll();

  }

}
