package com.SIGER.SIGER.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Sector;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.SectorRepository;


@Service
public class SectorServiceImpl extends BaseServiceImpl<Sector, Long> implements SectorService{
	
	@Autowired
    private SectorRepository sectorRepository;
	
	public SectorServiceImpl(BaseRepository<Sector, Long> baseRepository) {
        super(baseRepository);
    }

}
