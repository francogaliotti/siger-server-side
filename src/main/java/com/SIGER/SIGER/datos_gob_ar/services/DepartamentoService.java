package com.SIGER.SIGER.datos_gob_ar.services;

import com.SIGER.SIGER.datos_gob_ar.entities.Departamento;
import com.SIGER.SIGER.datos_gob_ar.repositories.DepartamentoRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

  @Autowired
  DepartamentoRepository departamentoRepository;

  @Transactional
  public Page<Departamento> findAll(int page, int size, Long id) throws Exception {
    Pageable pageable = PageRequest.of(page, size);
    return departamentoRepository.findByProvincia(pageable, id);

  }

  public List<Departamento> findAll(Long id) throws Exception {
    return departamentoRepository.getByProvincia(id);

  }

}
