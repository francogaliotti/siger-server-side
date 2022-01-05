package com.SIGER.SIGER.servicesInterfaces;

import com.SIGER.SIGER.model.entities.BaseEntity;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;


public interface BaseService<E extends BaseEntity, ID extends Serializable> {

  List<E> findAll() throws Exception;

  Page<E> findAll(int page, int size) throws Exception;

  E findById(ID id) throws Exception;

  E save(E entity) throws Exception;

  E update(ID id, E entity) throws Exception;

  void delete(ID id) throws Exception;

}
