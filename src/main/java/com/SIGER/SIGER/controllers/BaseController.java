package com.SIGER.SIGER.controllers;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.SIGER.SIGER.entities.BaseEntity;

public interface BaseController <E extends BaseEntity, ID extends Serializable>{
	
    ResponseEntity<?> getAll();

    ResponseEntity<?> getAll(Pageable pageable);

    ResponseEntity<?> getOne(@PathVariable ID id);

    ResponseEntity<?> save(@RequestBody E entity);

    ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity/*, @RequestBody DTO dto*/);

    ResponseEntity<?> delete(@PathVariable ID id);

}
