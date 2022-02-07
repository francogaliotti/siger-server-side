package com.SIGER.SIGER.seeders;

import com.SIGER.SIGER.model.entities.RegimenHorario;
import com.SIGER.SIGER.model.entities.TipoRegimenHorario;
import com.SIGER.SIGER.repositories.RegimenHorarioRepository;
import com.SIGER.SIGER.repositories.TipoRegimenHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Component
public class _1_RegimenHorarioSeeder implements CommandLineRunner {

    @Autowired
    RegimenHorarioRepository regimenHorarioRepository;

    @Autowired
    TipoRegimenHorarioRepository tipoRegimenHorarioRepository;

    @Override
    public void run(String... args) throws Exception {
        loadRegimenHorario();
    }


    private void loadRegimenHorario() {
        if (regimenHorarioRepository.count() == 0) {
            regimenHorarioRepository.save(buildRegimenHorario(convertStringToLocalDate("07:00"), convertStringToLocalDate("14:00"), Long.valueOf(1)));
            regimenHorarioRepository.save(buildRegimenHorario(convertStringToLocalDate("08:00"), convertStringToLocalDate("15:00"), Long.valueOf(3)));
            regimenHorarioRepository.save(buildRegimenHorario(convertStringToLocalDate("06:00"), convertStringToLocalDate("16:00"), Long.valueOf(3)));
        }
    }

    private RegimenHorario buildRegimenHorario(LocalTime horaMinutoInicioJornadaLaboral, LocalTime horaMinutoFinJornadaLaboral, Long tipoRegimenHorarioId) {
        Optional<TipoRegimenHorario> optionalTipoRegimenHorario = tipoRegimenHorarioRepository.findById(tipoRegimenHorarioId);
        RegimenHorario regimenHorario = RegimenHorario.builder()
                .fechaInicioVigenciaRegimenHorario(new Date())
                .horaMinutoInicioJornadaLaboral(horaMinutoInicioJornadaLaboral)
                .horaMinutoFinJornadaLaboral(horaMinutoFinJornadaLaboral)
                .isActive(true)
                .build();
        if (optionalTipoRegimenHorario.isPresent()) {
            regimenHorario.setTipoRegimenHorario(optionalTipoRegimenHorario.get());
        }
        return regimenHorario;
    }

    private LocalTime convertStringToLocalDate(String horaMinuto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm", Locale.US);
        return LocalTime.parse(horaMinuto, formatter);
    }

}
