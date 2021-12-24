package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.IDocumentoAdjuntoBoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.DocumentoAdjuntoBoleta;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.DocumentoAdjuntoBoletaRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class DocumentoAdjuntoBoletaService extends
    AbsBaseService<DocumentoAdjuntoBoleta, Long> implements
		IDocumentoAdjuntoBoletaService {
	
	@Autowired
	private DocumentoAdjuntoBoletaRepository documentoAdjuntoBoletaRepository;
	
	
	public DocumentoAdjuntoBoletaService(BaseRepository<DocumentoAdjuntoBoleta, Long> baseRepository) {
      super(baseRepository);
  }

}
