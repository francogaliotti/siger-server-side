package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.Viatico;
import com.SIGER.SIGER.repositories.ViaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class _0_ViaticoSeeder implements CommandLineRunner {

    @Autowired
    ViaticoRepository viaticoRepository;

    @Override
    public void run(String... args) throws Exception {
        loadViaticos();
    }


    private void loadViaticos(){
        if (viaticoRepository.count() == 0) {
            viaticoRepository.save(buildViatico("EB01", "Viatico de Gabinete",3000));
            viaticoRepository.save(buildViatico("EB02", "Viatico de Sereno",4000));
        }
    }

    private Viatico buildViatico(String codViatico, String denominacionViatico, double importe){
        return Viatico.builder()
                .codViatico(codViatico)
                .denominacionViatico(denominacionViatico)
                .importe(importe)
                .build();
    }


}
