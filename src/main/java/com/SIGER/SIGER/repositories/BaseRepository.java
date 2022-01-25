package com.SIGER.SIGER.repositories;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.SIGER.SIGER.model.entities.BaseEntity;

@NoRepositoryBean//El interface no puede instanciarse
public interface BaseRepository<E extends BaseEntity, ID extends Serializable> extends JpaRepository<E, ID> {

  Page<E> findBySoftDeleteFalse(Pageable pageable);

}
