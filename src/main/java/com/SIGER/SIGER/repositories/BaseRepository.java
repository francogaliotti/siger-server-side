package com.SIGER.SIGER.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.SIGER.SIGER.entities.BaseEntity;

@NoRepositoryBean//La interface no se puede instanciar
public interface BaseRepository<E extends BaseEntity, ID extends Serializable> extends JpaRepository<E, ID> {
	
}
