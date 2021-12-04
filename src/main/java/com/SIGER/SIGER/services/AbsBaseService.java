package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.BaseEntity;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.servicesInterfaces.BaseService;
import java.io.Serializable;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@NoArgsConstructor
public abstract class AbsBaseService<E extends BaseEntity, ID extends Serializable> implements
    BaseService<E, ID> {

  @Autowired
  protected BaseRepository<E, ID> baseRepository;

  public AbsBaseService(BaseRepository<E, ID> baseRepository) {
    this.baseRepository = baseRepository;
  }

	    /*@Override
	    @Transactional
	    public List<E> findAll() throws Exception {
	        try {
	            List<E> entities = baseRepository.findAll();
	            return entities;
	        } catch (Exception excep) {
	            throw new Exception(excep.getMessage());
	        }
	    }*/

  @Override
  @Transactional
  public Page<E> findAll(int page, int size) throws Exception {
    Pageable pageable = PageRequest.of(page, size);
    return baseRepository.findBySoftDeleteFalse(pageable);

  }

  @Override
  @Transactional
  public E findById(ID id) throws Exception {
    Optional<E> entityOptional = baseRepository.findById(id);
    E entity = validateEntityExists(entityOptional);
    validateEntity(entity);
    return entity;
  }

  @Override
  @Transactional
  public E save(E entity) throws Exception {
    return baseRepository.save(entity);
  }

  @Override
  @Transactional
  public E update(ID id, E entity) throws Exception {
    Optional<E> entityOptional = baseRepository.findById(id);
    E entityUpdate = validateEntityExists(entityOptional);
    validateEntity(entityUpdate);
    entityUpdate = entity;
    return baseRepository.save(entityUpdate);
  }

  @Override
  @Transactional
  public void delete(ID id) throws Exception {
    Optional<E> entityOptional = baseRepository.findById(id);
    E entity = validateEntityExists(entityOptional);
    validateEntity(entity);
    entity.setSoftDelete(true);
    baseRepository.save(entity);
  }

  private E validateEntityExists(Optional<E> entityOptional) {
    if (!entityOptional.isPresent()) {
      throw new EntityNotFoundException("The requested resource could not be found.");
    }
    return entityOptional.get();
  }

  private void validateEntity(E entity) {
    if (entity == null || entity.isSoftDelete()) {
      throw new EntityNotFoundException("The requested resource could not be found.");
    }
  }


}
