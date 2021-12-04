package com.SIGER.SIGER.services;

import com.SIGER.SIGER.servicesInterfaces.IDocumentoAdjuntoLicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.model.entities.DocumentoAdjuntoLicencia;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.DocumentoAdjuntoLicenciaRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class DocumentoAdjuntoLicenciaService extends
    AbsBaseService<DocumentoAdjuntoLicencia, Long> implements
		IDocumentoAdjuntoLicenciaService {
	
	@Autowired
	DocumentoAdjuntoLicenciaRepository documentoAdjuntoLicenciaRepository;
	
	
	public DocumentoAdjuntoLicenciaService(BaseRepository<DocumentoAdjuntoLicencia, Long> baseRepository) {
      super(baseRepository);
  }

}
