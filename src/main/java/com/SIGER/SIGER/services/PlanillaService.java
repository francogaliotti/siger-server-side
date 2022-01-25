package com.SIGER.SIGER.services;

import com.SIGER.SIGER.model.entities.Planilla;
import com.SIGER.SIGER.repositories.PlanillaRepository;
import com.SIGER.SIGER.servicesInterfaces.IPlanillaService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class PlanillaService  extends AbsBaseService<Planilla, Long> implements IPlanillaService {
    @Autowired
    PlanillaRepository _PlanillaRepository;

}
