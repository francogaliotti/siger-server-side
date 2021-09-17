package com.SIGER.SIGER.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.SIGER.SIGER.entities.BaseEntity;
import com.SIGER.SIGER.repositories.BaseRepository;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public abstract class BaseServiceImpl <E extends BaseEntity, ID extends Serializable> implements BaseService<E, ID>{

	@Autowired
	 protected BaseRepository<E, ID> baseRepository;

	    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
	        this.baseRepository = baseRepository;
	    }

	    @Override
	    @Transactional
	    public List<E> FindAll() throws Exception {
	        try {
	            List<E> entities = baseRepository.findAll();
	            return entities;
	        } catch (Exception excep) {
	            throw new Exception(excep.getMessage());
	        }
	    }

	    @Override
	    @Transactional
	    public Page<E> FindAll(Pageable pageable) throws Exception {
	        try {
	            Page<E> entities = baseRepository.findAll(pageable);
	            return entities;
	        } catch (Exception excep) {
	            throw new Exception(excep.getMessage());
	        }
	    }

	    @Override
	    @Transactional
	    public E FindById(ID id) throws Exception {
	        try {
	            Optional<E> entityOptional = baseRepository.findById(id);
	            return entityOptional.get();
	        } catch (Exception excep) {
	            throw new Exception((excep.getMessage()));
	        }
	    }

	    @Override
	    @Transactional
	    public E Save(E entity) throws Exception {
	        try {
	            entity = baseRepository.save(entity);
	            return entity;
	        } catch (Exception excep) {
	            throw new Exception(excep.getMessage());
	        }
	    }

	    @Override
	    @Transactional
	    public E Update(ID id, E entity) throws Exception {
	        try {
	            Optional<E> entityOptional = baseRepository.findById(id);

	            E entityUpdate = entityOptional.get();
	            entityUpdate = baseRepository.save(entity);

	            return entityUpdate;

	        } catch (Exception excep) {
	            throw new Exception(excep.getMessage());
	        }
	    }

	    @Override
	    @Transactional
	    public boolean Delete(ID id) throws Exception {
	        try {
	            if (baseRepository.existsById(id)) {
	                baseRepository.deleteById(id);
	                return true;
	            } else {
	                throw new Exception();
	            }

	        } catch (Exception excep) {
	            throw new Exception(excep.getMessage());
	        }
	    }

}
