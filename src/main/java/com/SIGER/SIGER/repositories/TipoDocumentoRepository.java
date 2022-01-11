package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.model.entities.TipoDocumento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepository extends BaseRepository<TipoDocumento, Long>{

  Page<TipoDocumento> findAll(Pageable pageable);

}
