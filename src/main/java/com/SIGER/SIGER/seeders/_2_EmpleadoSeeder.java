package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.Empleado;
import com.SIGER.SIGER.model.entities.Sector;
import com.SIGER.SIGER.repositories.EmpleadoRepository;
import com.SIGER.SIGER.repositories.SectorRepository;
import com.SIGER.SIGER.security.entity.Usuario;
import com.SIGER.SIGER.security.repository.UsuarioRepository;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class _2_EmpleadoSeeder implements CommandLineRunner {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    SectorRepository sectorRepository;

    @Override
    public void run(String... args) throws Exception {
        loadEmpleados();
    }

    private void loadEmpleados() {
        if (empleadoRepository.count() == 0) {
            empleadoRepository.save(
                    buildEmpleado("Jeremias", "Fernandez", "jfernandez@siger.com", 1, "1", false, Long.valueOf(1),Long.valueOf(2)));
            empleadoRepository.save(buildEmpleado("Alexis", "Bahi", "abahi@siger.com", 1, "2", false, Long.valueOf(2),Long.valueOf(3)));
            empleadoRepository.save(
                    buildEmpleado("Franco", "Galiotti", "fgaliotti@siger.com", 1, "3", false, Long.valueOf(3),Long.valueOf(4)));
            empleadoRepository.save(buildEmpleado("Diego", "Villa", "dvilla@siger.com", 1, "4", false, Long.valueOf(4),Long.valueOf(5)));
            empleadoRepository.save(
                    buildEmpleado("Jeremias", "Fernandez", "fernandez.jeremias.daniel@gmail.com", 1, "5", true,
                            Long.valueOf(5),Long.valueOf(1)));
            empleadoRepository.save(buildEmpleado("Alexis", "Bahi", "abahi.99@gmail.com", 1, "6", true, Long.valueOf(6),Long.valueOf(1)));
            empleadoRepository.save(
                    buildEmpleado("Franco", "Galiotti", "francogaliotti@gmail.com", 1, "7", true, Long.valueOf(7),Long.valueOf(1)));
            empleadoRepository.save(
                    buildEmpleado("Diego", "Villa", "diegovillautnfrm@gmail.com", 1, "8", true, Long.valueOf(8),Long.valueOf(1)));
        }
    }

    private Empleado buildEmpleado(String nombre, String apellido, String correoPersonal,
                                   int estadoCivil, String legajo, boolean esEncargado, Long usuarioId, Long sectorId) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioId);
        Optional<Sector> optionalSector = sectorRepository.findById(sectorId);
        Empleado empleado = Empleado.builder()
                .fechaAlta(new Date())
                .nombre(nombre)
                .apellido(apellido)
                .correoPersonal(correoPersonal)
                .estadoCivil(estadoCivil)
                .legajo(legajo)
                //.fechaNacimiento(fechaNacimiento)
                .fechaIngreso(new Date())
                .esEncargado(esEncargado)
                //.nroTelefonoFijo()
                //.nroTelefonoCelular()
                .build();

        if (optionalUsuario.isPresent()){
            empleado.setUsuario(optionalUsuario.get());
        }
        if (optionalSector.isPresent()){
            empleado.setSector(optionalSector.get());
        }
        return empleado;
    }

}
