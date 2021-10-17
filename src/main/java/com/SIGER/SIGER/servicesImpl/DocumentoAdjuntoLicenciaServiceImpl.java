package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.services.DocumentoAdjuntoLicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.DocumentoAdjuntoLicencia;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.DocumentoAdjuntoLicenciaRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class DocumentoAdjuntoLicenciaServiceImpl extends BaseServiceImpl<DocumentoAdjuntoLicencia, Long> implements DocumentoAdjuntoLicenciaService {
	
	@Autowired
	private DocumentoAdjuntoLicenciaRepository documentoAdjuntoLicenciaRepository;
	
	
	public DocumentoAdjuntoLicenciaServiceImpl(BaseRepository<DocumentoAdjuntoLicencia, Long> baseRepository) {
      super(baseRepository);
  }

}
