package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.Nacionalidad;
import com.SIGER.SIGER.repositories.NacionalidadRepository;
import com.SIGER.SIGER.servicesInterfaces.INacionalidadService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class NacionalidadService extends AbsBaseService<Nacionalidad, Long> implements INacionalidadService {
    @Autowired
    private NacionalidadRepository nationalityRepository;

}
