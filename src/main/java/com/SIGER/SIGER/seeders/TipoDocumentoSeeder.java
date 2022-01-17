package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.TipoDocumento;
import com.SIGER.SIGER.repositories.TipoDocumentoRepository;
import com.SIGER.SIGER.security.entity.Rol;
import com.SIGER.SIGER.security.enums.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TipoDocumentoSeeder implements CommandLineRunner {

  @Autowired
  TipoDocumentoRepository tipoDocumentoRepository;


  @Override
  public void run(String... args) throws Exception {
    loadRoles();
  }

  private void loadRoles() {
    if (tipoDocumentoRepository.count() == 0) {
      tipoDocumentoRepository.save(buildTipoDocumento("D.N.I."));
      tipoDocumentoRepository.save(buildTipoDocumento("C.U.I.L."));
      tipoDocumentoRepository.save(buildTipoDocumento("Pasaporte"));
      tipoDocumentoRepository.save(buildTipoDocumento("R.U.T."));
      tipoDocumentoRepository.save(buildTipoDocumento("D.N.I.C."));
      tipoDocumentoRepository.save(buildTipoDocumento("C.C."));
      tipoDocumentoRepository.save(buildTipoDocumento("R.G."));
    }
  }

  private TipoDocumento buildTipoDocumento(String tipoDocumentoNombre) {
    TipoDocumento tipoDocumento = new TipoDocumento();
    tipoDocumento.setTipoDocumento(tipoDocumentoNombre);
    return tipoDocumento;
  }

}
