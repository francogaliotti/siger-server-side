package com.SIGER.SIGER.repositories;

import com.SIGER.SIGER.model.entities.TipoDocumento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoDocumentoRepository extends BaseRepository<TipoDocumento, Long>{

  List<TipoDocumento> findAll();

}
