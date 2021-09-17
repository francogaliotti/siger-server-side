package com.SIGER.SIGER.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.SIGER.SIGER.entities.BaseEntity;
import com.SIGER.SIGER.services.BaseServiceImpl;

public abstract class BaseControllerImpl <E extends BaseEntity, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long>{
	
	@Autowired
    protected S servicio;

}
