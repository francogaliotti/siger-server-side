package com.SIGER.SIGER.servicesImpl;

import com.SIGER.SIGER.entities.EstadoLicencia;
import com.SIGER.SIGER.services.TipoLicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.TipoLicencia;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.TipoLicenciaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class TipoLicenciaServiceImpl extends BaseServiceImpl<TipoLicencia, Long> implements TipoLicenciaService {
	
	@Autowired
    private TipoLicenciaRepository tipoLicenciaRepository;


    public Optional<TipoLicencia> getByNombreTipoLicencia(String nombre){
        return tipoLicenciaRepository.findByDenominacion(nombre);
    }

    public boolean existsById (Long id) {
        return tipoLicenciaRepository.existsById(id);
    }

    public boolean existsByNombreTipoLicencia (String nombre) {
        return tipoLicenciaRepository.existsByDenominacion(nombre);
    }

}
