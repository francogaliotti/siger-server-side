package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.BaseEntity;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.servicesInterfaces.BaseService;
import java.io.Serializable;
import java.util.List;
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

  @Override
  @Transactional
  public List<E> findAll() throws Exception{
    return baseRepository.findAll();
  }

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
    validateEntityExists(entityOptional);
    E entity = validateEntity(entityOptional);
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
    validateEntityExists(entityOptional);
    validateEntity(entityOptional);
    E entityToUpdate = entity;
    entityToUpdate.setId(entityOptional.get().getId());
    return baseRepository.save(entityToUpdate);
  }

  @Override
  @Transactional
  public void delete(ID id) throws Exception {
    Optional<E> entityOptional = baseRepository.findById(id);
    validateEntityExists(entityOptional);
    E entity =  validateEntity(entityOptional);
    entity.setSoftDelete(true);
    baseRepository.save(entity);
  }

  private void validateEntityExists(Optional<E> entityOptional) {
    if (!entityOptional.isPresent()) {
      throw new EntityNotFoundException("The requested resource could not be found.");
    }

  }

  private E validateEntity(Optional<E> entityOptional) {
    if (entityOptional == null || entityOptional.get().isSoftDelete()) {
      throw new EntityNotFoundException("The requested resource could not be found.");
    }
    return entityOptional.get();
  }


}
