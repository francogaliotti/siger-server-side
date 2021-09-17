package com.SIGER.SIGER.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.DocumentoAdjuntoBoleta;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.DocumentoAdjuntoBoletaRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class DocumentoAdjuntoBoletaServiceImpl extends BaseServiceImpl<DocumentoAdjuntoBoleta, Long> implements DocumentoAdjuntoBoletaService{
	
	@Autowired
	private DocumentoAdjuntoBoletaRepository documentoAdjuntoBoletaRepository;
	
	
	public DocumentoAdjuntoBoletaServiceImpl(BaseRepository<DocumentoAdjuntoBoleta, Long> baseRepository) {
      super(baseRepository);
  }

}
